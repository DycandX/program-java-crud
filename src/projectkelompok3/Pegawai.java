package projectkelompok3;
import java.sql.ResultSet;
import java.sql.* ;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author warse
 */
public class Pegawai extends Data {
    private String id;
    private String nip;
    private String nama;
    private String tempat;
    private String lahir;
    private String sex;
    private String agama;
    private String hp;
    private String jabatan;
    private String alamat;
    private String kota;
    private String aktif;
    private String status;
    private String email;
            
    public Pegawai(String id, String nip, String nama, String tempat, String lahir,
            String sex, String agama, String hp, String jabatan, String alamat, String kota, String aktif,
            String status, String email) {
        super(nama, alamat);
        this.id = id;
        this.nip = nip;
        this.nama = nama;
        this.tempat = tempat;
        this.lahir = lahir;
        this.sex = sex;
        this.agama = agama;
        this.hp	 = hp;
        this.jabatan = jabatan;
        this.alamat = alamat;
        this.kota = kota;
        this.aktif = aktif;
        this.status = status;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getAktif() {
        return aktif;
    }

    public void setAktif(String aktif) {
        this.aktif = aktif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public void info() {
        System.out.println("ID: " + getId());
        System.out.println("Nip: " + getNip());
        System.out.println("Nama: " + getNama());
        System.out.println("Tempat: " + getTempat());
        System.out.println("Lahir: " + getLahir());
        System.out.println("Sex: " + getSex());
        System.out.println("Agama: " + getAgama());
        System.out.println("Hp: " + getHp());
        System.out.println("Jabatan: " + getJabatan());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("Kota: " + getKota());
        System.out.println("Aktif: " + getAktif());
        System.out.println("Status: " + getStatus());
        System.out.println("Email: " + getEmail());
    }
    
    public static void viewData(Pegawai pegawai, String id) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        String sql = "SELECT * FROM r_pegawai WHERE id = '" + id + "' " ;
        try (PreparedStatement q = db.prepareStatement(sql)) {
            ResultSet rs = q.executeQuery();
            while (rs.next()) {
                pegawai.setId(rs.getString("id"));
                pegawai.setNip(rs.getString("nip"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setTempat(rs.getString("tempat"));
                pegawai.setLahir(rs.getString("lahir"));
                pegawai.setSex(rs.getString("sex"));
                pegawai.setAgama(rs.getString("agama"));
                pegawai.setHp(rs.getString("hp"));
                pegawai.setJabatan(rs.getString("jabatan"));
                pegawai.setAlamat(rs.getString("alamat"));
                pegawai.setKota(rs.getString("kota"));
                pegawai.setAktif(rs.getString("aktif"));
                pegawai.setStatus(rs.getString("status"));
                pegawai.setEmail(rs.getString("email"));
            } // end while
        } // end try
        
    }
 
    public static void bacaData(DefaultTableModel tb, String sql) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        try (PreparedStatement q = db.prepareStatement(sql)) {
            System.out.println(sql);
            ResultSet rs = q.executeQuery();
            while (rs.next()) {
                tb.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nip"),
                    rs.getString("nama"),
                    rs.getString("tempat"),
                    rs.getString("lahir"),
                    rs.getString("sex"),
                    rs.getString("agama"),
                    rs.getString("hp"),
                    rs.getString("jabatan"),
                    rs.getString("alamat"),
                    rs.getString("kota"),
                    rs.getString("aktif"),
                    rs.getString("status"),
                    rs.getString("email"),
                });
            } // end while
        } // end try
    } // end bacaData
 
    public static void addData(Pegawai pegawai) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        String sql = "INSERT INTO r_pegawai (id, nip, nama, tempat, lahir, sex, agama, hp, jabatan, alamat, kota, aktif	, status, email)"
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement q = db.prepareStatement(sql)) {
            q.setString(1, pegawai.getId());
            q.setString(2, pegawai.getNip());
            q.setString(3, pegawai.getNama());
            q.setString(4, pegawai.getTempat());
            q.setString(5, pegawai.getLahir());
            q.setString(6, pegawai.getSex());
            q.setString(7, pegawai.getAgama());
            q.setString(8, pegawai.getHp());
            q.setString(9, pegawai.getJabatan());
            q.setString(10, pegawai.getAlamat());
            q.setString(11, pegawai.getKota());
            q.setString(12, pegawai.getAktif());
            q.setString(13, pegawai.getStatus());
            q.setString(14, pegawai.getEmail());
            q.executeUpdate();
        }
     }
 
    public void Edit(Pegawai pegawai) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        String sql = "UPDATE r_pegawai SET kode = ?, nama = ?, jenisid = ?, cp = ?, alamat = ?, telp = ?, fax = ?, kota = ?, email = ?, jt = ?, disc = ?, AWAL = ?, Piutang = ?, Bayar = ?, Akhir = ?, tgl = ?, userid = ?, pwd = ? WHERE id = ?";

        try (PreparedStatement q = db.prepareStatement(sql)) {
            q.setString(1, pegawai.getId());
            q.setString(2, pegawai.getNip());
            q.setString(3, pegawai.getNama());
            q.setString(4, pegawai.getTempat());
            q.setString(5, pegawai.getLahir());
            q.setString(6, pegawai.getSex());
            q.setString(7, pegawai.getAgama());
            q.setString(8, pegawai.getHp());
            q.setString(9, pegawai.getJabatan());
            q.setString(10, pegawai.getAlamat());
            q.setString(11, pegawai.getKota());
            q.setString(12, pegawai.getAktif());
            q.setString(13, pegawai.getStatus());
            q.setString(14, pegawai.getEmail());
            q.executeUpdate();
        }
    }
    
    public static boolean Del(String id) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        boolean tf;
        String sql = "DELETE FROM r_pegawai WHERE id = '" + id + "' ";
        try (PreparedStatement q = db.prepareStatement(sql)) {
            int efek = q.executeUpdate();
            if (efek > 0) {
                tf=true;
            } else {
                tf=false;
            }
        }
        return tf;
    }
}