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

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisid() {
        return jenisid;
    }

    public void setJenisid(String jenisid) {
        this.jenisid = jenisid;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJt() {
        return jt;
    }

    public void setJt(String jt) {
        this.jt = jt;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getAWAL() {
        return AWAL;
    }

    public void setAWAL(String AWAL) {
        this.AWAL = AWAL;
    }

    public String getPiutang() {
        return Piutang;
    }

    public void setPiutang(String Piutang) {
        this.Piutang = Piutang;
    }

    public String getBayar() {
        return Bayar;
    }

    public void setBayar(String Bayar) {
        this.Bayar = Bayar;
    }

    public String getAkhir() {
        return Akhir;
    }

    public void setAkhir(String Akhir) {
        this.Akhir = Akhir;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    @Override
    public void info() {
        System.out.println("ID: " + getId());
        System.out.println("Kode: " + getKode());
        System.out.println("Nama: " + getNama());
        System.out.println("Jenis ID: " + getJenisid());
        System.out.println("Contact Person: " + getCp());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("Telp: " + getTelp());
        System.out.println("Fax: " + getFax());
        System.out.println("Kota: " + getKota());
        System.out.println("Email: " + getEmail());
        System.out.println("JT: " + getJt());
        System.out.println("Disc: " + getDisc());
        System.out.println("AWAL: " + getAWAL());
        System.out.println("Piutang: " + getPiutang());
        System.out.println("Bayar: " + getBayar());
        System.out.println("Akhir: " + getAkhir());
        System.out.println("Tanggal: " + getTgl());
        System.out.println("User ID: " + getUserid());
        System.out.println("Password: " + getPwd());
    }
    
    public static void viewData(Pegawai customer, String id) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        String sql = "SELECT * FROM r_customer WHERE id = '" + id + "' " ;
        try (PreparedStatement q = db.prepareStatement(sql)) {
            ResultSet rs = q.executeQuery();
            while (rs.next()) {
                customer.setId(rs.getString("id"));
                customer.setKode(rs.getString("kode"));
                customer.setNama(rs.getString("nama"));
                customer.setJenisid(rs.getString("jenisid"));
                customer.setCp(rs.getString("cp"));
                customer.setAlamat(rs.getString("alamat"));
                customer.setTelp(rs.getString("telp"));
                customer.setFax(rs.getString("fax"));
                customer.setKota(rs.getString("kota"));
                customer.setEmail(rs.getString("email"));
                customer.setJt(rs.getString("jt"));
                customer.setDisc(rs.getString("disc"));
                customer.setAWAL(rs.getString("AWAL"));
                customer.setPiutang(rs.getString("Piutang"));
                customer.setBayar(rs.getString("Bayar"));
                customer.setAkhir(rs.getString("Akhir"));
                customer.setTgl(rs.getString("tgl"));
                customer.setUserid(rs.getString("userid"));
                customer.setPwd(rs.getString("pwd"));
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
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getString("jenisid"),
                    rs.getString("cp"),
                    rs.getString("alamat"),
                    rs.getString("telp"),
                    rs.getString("fax"),
                    rs.getString("kota"),
                    rs.getString("email"),
                    rs.getString("jt"),
                    rs.getString("disc"),
                    rs.getString("AWAL"),
                    rs.getString("Piutang"),
                    rs.getString("Bayar"),
                    rs.getString("Akhir"),
                    rs.getString("tgl"),
                    rs.getString("userid"),
                    rs.getString("pwd")
                });
            } // end while
        } // end try
    } // end bacaData
 
    public static void addData(Pegawai customer) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        String sql = "INSERT INTO r_customer (id, kode, nama, jenisid, cp, alamat, telp, fax, kota, email, jt, disc, AWAL, Piutang, Bayar, Akhir, tgl, userid, pwd)"
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement q = db.prepareStatement(sql)) {
            q.setString(1, customer.getId());
            q.setString(2, customer.getKode());
            q.setString(3, customer.getNama());
            q.setString(4, customer.getJenisid());
            q.setString(5, customer.getCp());
            q.setString(6, customer.getAlamat());
            q.setString(7, customer.getTelp());
            q.setString(8, customer.getFax());
            q.setString(9, customer.getKota());
            q.setString(10, customer.getEmail());
            q.setString(11, customer.getJt());
            q.setString(12, customer.getDisc());
            q.setString(13, customer.getAWAL());
            q.setString(14, customer.getPiutang());
            q.setString(15, customer.getBayar());
            q.setString(16, customer.getAkhir());
            q.setString(17, customer.getTgl());
            q.setString(18, customer.getUserid());
            q.setString(19, customer.getPwd());
            q.executeUpdate();
        }
     }
 
    public void Edit(Pegawai customer) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        String sql = "UPDATE r_customer SET kode = ?, nama = ?, jenisid = ?, cp = ?, alamat = ?, telp = ?, fax = ?, kota = ?, email = ?, jt = ?, disc = ?, AWAL = ?, Piutang = ?, Bayar = ?, Akhir = ?, tgl = ?, userid = ?, pwd = ? WHERE id = ?";

        try (PreparedStatement q = db.prepareStatement(sql)) {
            q.setString(1, customer.getId());
            q.setString(2, customer.getKode());
            q.setString(3, customer.getNama());
            q.setString(4, customer.getJenisid());
            q.setString(5, customer.getCp());
            q.setString(6, customer.getAlamat());
            q.setString(7, customer.getTelp());
            q.setString(8, customer.getFax());
            q.setString(9, customer.getKota());
            q.setString(10, customer.getEmail());
            q.setString(11, customer.getJt());
            q.setString(12, customer.getDisc());
            q.setString(13, customer.getAWAL());
            q.setString(14, customer.getPiutang());
            q.setString(15, customer.getBayar());
            q.setString(16, customer.getAkhir());
            q.setString(17, customer.getTgl());
            q.setString(18, customer.getUserid());
            q.setString(19, customer.getPwd());
            q.executeUpdate();
        }
    }
    
    public static boolean Del(String id) throws SQLException {
        Connection db = ConnectionDB.getConnection();
        boolean tf;
        String sql = "DELETE FROM r_customer WHERE id = '" + id + "' ";
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