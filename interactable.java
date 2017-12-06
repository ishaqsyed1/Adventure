public interface interactable {
    void interact();
    void interact(Thing t);
    void interact(Player p);
    String getInteractOption();
}
