package MonAn.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "monan")
public class MonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int monAnId;
    @Column(name = "tenmon")
    private String tenMon;
    @Column(name = "giaban")
    private int giaBan;
    @Column(name = "gioithieu")
    private String gioiThieu;
    @Column(name = "cachlam")
    private String cachLam;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loaiMonAnId")
    @JsonIgnoreProperties(value = "monAn")
    private LoaiMonAn loaiMonAn;

    @OneToMany(mappedBy = "monAn")
    @JsonIgnoreProperties(value = "monAn")
    private Set<CongThuc> congThucs;

    public int getMonAnId() {
        return monAnId;
    }

    public void setMonAnId(int monAnId) {
        this.monAnId = monAnId;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public String getCachLam() {
        return cachLam;
    }

    public void setCachLam(String cachLam) {
        this.cachLam = cachLam;
    }

    public LoaiMonAn getLoaiMonAn() {
        return loaiMonAn;
    }

    public void setLoaiMonAn(LoaiMonAn loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
    }

    public Set<CongThuc> getCongThucs() {
        return congThucs;
    }

    public void setCongThucs(Set<CongThuc> congThucs) {
        this.congThucs = congThucs;
    }
}
