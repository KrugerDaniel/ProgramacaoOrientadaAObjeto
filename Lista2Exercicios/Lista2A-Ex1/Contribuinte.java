public class Contribuinte {
	private String nome;
    private String cpf;
    private String uf;
    private double rendaAnual;
    
    public Contribuinte() {}
    
    public Contribuinte(String nome, String cpf, String uf, double rendaAnual) {
    	this.nome = nome;
    	this.cpf = cpf;
    	this.uf = uf;
    	this.rendaAnual = rendaAnual;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getUf() {
        return this.uf;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public double getRendaAnual() {
        return this.rendaAnual;
    }
    
    public void setRendaAnual(double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public double getAliquota() {
        double aliquota = 0;

        if (this.rendaAnual > 35000) {
            aliquota = 0.3;
        } else if (this.rendaAnual >= 25001) {
            aliquota = 0.275;
        } else if (this.rendaAnual >= 9001) {
            aliquota = 0.15;
        } else if (this.rendaAnual >= 4001) {
            aliquota = 0.058;
        }

        return aliquota;
    }

    public double calcularImposto() {
        return this.rendaAnual * this.getAliquota();
    }
}
