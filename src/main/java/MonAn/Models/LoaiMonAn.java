package MonAn.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "loaimonan")
public class LoaiMonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loaiMonAnId;
    @Column(name = "tenloai")
    @Size(max = 20, message = "ten loai khong duoc qua 20 ky tu")
    private String tenLoai;
    @Column(name = "mota")
    private String moTa;

    @OneToMany(mappedBy = "loaiMonAn")
    @JsonIgnoreProperties(value = "loaiMonAn")
    private Set<MonAn> monAns;

    public int getLoaiMonAnId() {
        return loaiMonAnId;
    }

    public void setLoaiMonAnId(int loaiMonAnId) {
        this.loaiMonAnId = loaiMonAnId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Set<MonAn> getMonAns() {
        return monAns;
    }

    public void setMonAns(Set<MonAn> monAns) {
        this.monAns = monAns;
    }
}
