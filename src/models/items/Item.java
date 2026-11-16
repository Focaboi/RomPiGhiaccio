package models.items;

public abstract class Item {
    private String nome;
    private double peso;
    private double valore;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getValore() {
        return valore;
    }
    public void setValore(double valore) {
        this.valore = valore;
    }

    public Item(String nome, double peso, double valore) {
        this.nome = nome;
        this.peso = peso;
        this.valore = valore;
    }
    @Override
    public String toString() {
        return nome + ", " + peso + "g, " + valore + " Monete";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        long temp;
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(valore);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        if (Double.doubleToLongBits(valore) != Double.doubleToLongBits(other.valore))
            return false;
        return true;
    }
    
}
