package MonAn.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import javax.print.attribute.standard.MediaSize;
import java.util.Set;

@Entity
@Table(name = "nguyenlieu")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nguyenLieuId;
    @Column(name = "tennguyenlieu")
    @Size(max = 20, message = "ten nguyen lieu khong duoc qua 20 ky tu")

    private String tenNguyenLieu;
    @Column(name = "ghichu")
    private String ghiChu;

    @OneToMany(mappedBy = "nguyenLieu")
    @JsonIgnoreProperties(value = "nguyenLieu")
    private Set<CongThuc> congThucs;

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Set<CongThuc> getCongThucs() {
        return congThucs;
    }

    public void setCongThucs(Set<CongThuc> congThucs) {
        this.congThucs = congThucs;
    }
}
