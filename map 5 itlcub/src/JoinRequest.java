public class JoinRequest {                                    // element of the queue
    private static int counter = 0;
    private final int seq = counter++;
    //seq — номер заявки.
    private final ITClub candidate; private final int priority;
    //final — значение нельзя изменить после присваивания.
    public JoinRequest(ITClub candidate, int priority) { this.candidate = candidate; this.priority = priority; }

    public ITClub getCandidate() { return candidate; }
    public int getPriority() { return priority; }
    public int getSeq() { return seq; }
    @Override public boolean equals(Object o) { return o instanceof JoinRequest && this.seq == ((JoinRequest) o).seq; }
    @Override public int hashCode() { return Integer.hashCode(seq); }
}

