public class WeissWein extends Wein {

    public WeissWein(float alkoholgehalt, String weingut) {
        super(alkoholgehalt, weingut);
    }

    @Override
    public String toString() {
        return super.toString() + " Weisswein";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WeissWein) {
            WeissWein other = (WeissWein) obj;
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
