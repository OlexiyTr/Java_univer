import java.util.*;

public class task_15_2 {
    private final static int EMPTY = 0;
    private final static int BUSY = 1;

    private final static char SYMBOL_EMPTY = '\u25A1';
    private final static char SYMBOL_SHAPE = 9632;

    private final int[][] matrix;
    private final List<Shape> shapes;

    task_15_2(int[][] matrix) {
        this.matrix = matrix;
        this.shapes = getAllShapes(cloneMatrix(matrix));
    }

    private List<Shape> getAllShapes(int[][] matrix) {
        List<Shape> set = new ArrayList<>();
        if (matrix != null) {
            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[y].length; x++) {
                    if (matrix[y][x] != EMPTY) {
                        Shape shape = recursionSearchShape(x, y, new Shape(), matrix);
                        shape.displaceShape();
                        set.add(shape);
                    }
                }
            }
        }
        return set;
    }

    private int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        int count = 0;
        for (int[] line : matrix) {
            clone[count++] = line.clone();
        }
        return clone;
    }

    private boolean checkXY(int x, int y) {
        return y >= 0 && y < this.matrix.length && x >= 0 && x < this.matrix[y].length;
    }

    private Shape recursionSearchShape(int x, int y, Shape res, int[][] matrix) {
        if (checkXY(x, y) && matrix[y][x] != EMPTY) {
            res.addPoint(new Point(x, y));
            matrix[y][x] = EMPTY;
            res = recursionSearchShape(x + 1, y, res, matrix);
            res = recursionSearchShape(x - 1, y, res, matrix);
            res = recursionSearchShape(x, y + 1, res, matrix);
            res = recursionSearchShape(x, y - 1, res, matrix);
        }
        return res;
    }

    private String toStringMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        if (matrix != null) {
            for (int[] line : matrix) {
                for (int value : line) {
                    sb.append(value == EMPTY ? SYMBOL_EMPTY : SYMBOL_SHAPE);
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringMatrix(this.matrix);
    }

    public String getShapes() {
        return getString(this.shapes);
    }

    private String getString(Collection<Shape> c) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : c) {
            sb.append(shape).append("\n");
        }
        return sb.toString();
    }

    public String getShapeWithoutDuplicate() {
        return getString(getShapesWithoutDuplicate());
    }

    public String getUniqueShapes() {
        return getString(getUniqueShape());
    }

    private Set<Shape> getUniqueShape() {
        Set<Shape> clearSet = new HashSet<>();
        Set<Shape> duplicate = new HashSet<>();
        for (Shape shape : this.shapes) {
            if (!clearSet.contains(shape)) {
                clearSet.add(shape);
            } else {
                duplicate.add(shape);
            }
        }
        if (!duplicate.isEmpty()) {
            for (Shape shape : duplicate) {
                clearSet.remove(shape);
            }
        }
        return clearSet;
    }

    private Set<Shape> getShapesWithoutDuplicate() {
        Set<Shape> set = new HashSet<>();
        Collections.addAll(set, this.shapes.toArray(new Shape[0]));
        return set;
    }

    class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", this.x, this.y);
        }
    }

    class Shape {
        private final HashSet<Point> points;

        Shape() {
            this.points = new HashSet<>();
        }

        private void addPoint(Point point) {
            this.points.add(point);
        }

        private Point getMinXY() {
            int minX = this.points.isEmpty() ? 0 : Integer.MAX_VALUE;
            int minY = this.points.isEmpty() ? 0 : Integer.MAX_VALUE;
            for (Point point : this.points) {
                if (point.x < minX) {
                    minX = point.x;
                }
                if (point.y < minY) {
                    minY = point.y;
                }
            }
            return new Point(minX, minY);
        }

        private Point getMaxXY() {
            int maxX = 0;
            int maxY = 0;
            for (Point point : this.points) {
                if (point.x > maxX) {
                    maxX = point.x;
                }
                if (point.y > maxY) {
                    maxY = point.y;
                }
            }
            return new Point(maxX, maxY);
        }

        private void displaceShape() {
            Point min = getMinXY();
            for (Point point : this.points) {
                point.x -= min.x;
                point.y -= min.y;
            }
        }

        private int[][] shapeToMatrix() {
            Point max = getMaxXY();
            int[][] matrix = new int[max.y + 1][max.x + 1];
            for (Point point : this.points) {
                matrix[point.y][point.x] = BUSY;
            }
            return matrix;
        }

        @Override
        public int hashCode() {
            Shape shape = this;
            long sum = shape.points.hashCode();
            for (int count = 0; count < 3; count++) {
                shape = shape.turn();
                sum += shape.points.hashCode();
            }
            return (int) sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Shape shape = (Shape) o;

            boolean result = false;
            Shape my = this;
            for (int i = 0; i < 4; i++) {
                if (my.points.equals(shape.points)) {
                    result = true;
                    break;
                }
                my = my.turn();
            }
            return result;
        }

        private Shape turn() {
            Point max = getMaxXY();
            Shape shape = new Shape();
            for (Point point : this.points) {
                shape.addPoint(new Point(point.y, max.x - point.x));
            }
            return shape;
        }

        @Override
        public String toString() {
            return toStringMatrix(shapeToMatrix());
        }
    }
}

class ShapesTest {
    private static final int[][] PAPER = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    public static void main(String[] args) {
        task_15_2 shape = new task_15_2(PAPER);

        System.out.println("Print paper with shapes:\n" + shape);

        System.out.println("\nPrint all shapes:\n" + shape.getShapes());

        System.out.println("\nPrint shapes without duplicate:\n" + shape.getShapeWithoutDuplicate());

        System.out.println("\nPrint unique shapes:\n" + shape.getUniqueShapes());


    }
}