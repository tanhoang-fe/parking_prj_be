package mock.prj.finalp.model;

public enum PackageType {
    Week(0),Month(0),Quarter(5),HalfYear(10),FullYear(15);
    private int discountPercent;

    private PackageType(int discountPercent) {
        this.discountPercent = discountPercent;
    }
}
