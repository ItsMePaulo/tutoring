public enum VertexType {
    ENTRANCE('E'), BLANK('.'), KEY('K'), TREASURE('T'), TRAP('X'), WALL('#');

    private Character symbol;

    VertexType(Character c) {
        symbol = c;
    }

    static boolean isValidCharacter(Character c) {
        boolean isValid = false;

        for (VertexType type: VertexType.values()) {
            if (c == type.symbol) {
                isValid = true;
            }
        }

        return isValid;
    }

    static VertexType getType(Character c) {

        for (VertexType type: VertexType.values()) {
            if (c == type.symbol) {
                return type;
            }
        }

        return WALL;
    }
}
