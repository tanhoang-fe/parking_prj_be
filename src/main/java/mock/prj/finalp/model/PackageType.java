package mock.prj.finalp.model;

public enum PackageType {
    Week(7),Month(30),Quarter(90),HalfYear(183),FullYear(365);
    public int dayInPackage;

    private PackageType(int dayInPackage) {
        this.dayInPackage = dayInPackage;
    }
}
