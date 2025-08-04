package lld.questions.cricbuzz;


interface Subscriber {
    void handleOut();
    void handleBoundary();
    void handleNoBall();
}

interface Publisher {
    void notifyOut(Player player);
    void notifyBoundary(Player player);
    void notifyNoBall(Player player);
}