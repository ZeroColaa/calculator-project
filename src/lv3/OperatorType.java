package lv3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('x'),
    DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) { //enum 생성자는 항상 private임
        this.symbol = symbol;
    }

    //사용자 입력(char)를 OperatorType으로 변환
    public static OperatorType fromChar(char input) {
        for (OperatorType op : values()) {
            if (op.symbol == input) return op;
        }
        throw new IllegalArgumentException("지원하지 않는 연산자:" + input);
    }
}