package Domain;

public class Member {
    int mnr;
    String fornavn;
    String efternavn;

    public MemberType getMedlemstype() {
        return medlemstype;
    }

    public void setMedlemstype(MemberType medlemstype) {
        this.medlemstype = medlemstype;
    }

    MemberType medlemstype;

    public Member(int mnr, String fornavn, String efternavn, MemberType medlemstype) {
        this.mnr = mnr;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.medlemstype = medlemstype;


    }

    public int getMnr() {
        return mnr;
    }

    public void setMnr(int mnr) {
        this.mnr = mnr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }
}
