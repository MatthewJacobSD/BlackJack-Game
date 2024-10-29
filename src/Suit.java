public enum Suit {
    heartsGrp("Hearts"), spadesGrp("Spades"), diamondsGrp("Diamonds"), clubsGrp("Clubs");

    private final String suitGroup;

    private Suit(String suitGroup) {
    this.suitGroup = suitGroup;
    }

    public String getSuitGroup() {
        return suitGroup;
    }
}

