


public class Valor
{
    //Atributos
    Simbolo.TipoSimbolo tipo;
    long valorInteger;
    float valorFloat;
    String valorString;
    Polinomio valorPolinomio;
    /**
     * Constructor valor
     * @param valor
     * @param tipo
     */
    public Valor (Object valor, Simbolo.TipoSimbolo tipo)
    {
        switch (tipo)
        {
            case INT:
                this.valorInteger = (long) valor;
                break;
            case FLOAT:
                this.valorFloat = (float) valor;
                break;
            case TEXT:
                this.valorString =  valor.toString();
                break;
            case POLYNOMIAL:
                this.valorPolinomio =  (Polinomio) valor;
                break;
        }
        this.tipo = tipo;
    }


    /**
     * Constructor para int
     * @param valor
     */
    public Valor(long valor)
    {
        this.valorInteger = valor;
        this.tipo = Simbolo.TipoSimbolo.INT;
    }

    /**
     * Constructor para polinomio
     * @param valor
     */
    public Valor(Polinomio valor)
    {
        this.valorPolinomio = valor;
        this.tipo = Simbolo.TipoSimbolo.POLYNOMIAL;
    }


    /**
     * Constructor para float
     * @param valor
     */
    public Valor(float valor)
    {
        this.valorFloat = valor;
        this.tipo = Simbolo.TipoSimbolo.FLOAT;
    }

    /**
     * Constructor para String
     * @param valor
     */
    public Valor(String valor)
    {
        this.valorString = valor;
        this.tipo = Simbolo.TipoSimbolo.TEXT;
    }

    /**
     * Obtiene el valor en integer
     * @return
     */
    public long getInt()
    {
        return this.valorInteger;
    }

    /**
     * Obtiene el valor en float
     * @return
     */
    public float getFloat()
    {
        return  this.valorFloat;
    }

    /**
     * Obtiene el valor en String
     * @return
     */
    public String getString()
    {
        return this.valorString;
    }

    /**
     * Obtiene el tipo polinomio
     * @return
     */
    public Polinomio getValorPolinomio()
    {
        return this.valorPolinomio;
    }
    /**
     * Obtiene el tipo del valor
     * @return
     */
    public Simbolo.TipoSimbolo getTipo()
    {
        return this.tipo;

    }

    /**
     * Setea el nuevo valor integer
     * @param valorInteger
     */
    public void setValorInteger(long valorInteger) {
        this.valorInteger = valorInteger;
        this.tipo = Simbolo.TipoSimbolo.INT;
    }

    /**
     * Setea el nuevo valor del float
     * @param valorFloat
     */
    public void setValorFloat(float valorFloat) {
        this.valorFloat = valorFloat;
        this.tipo = Simbolo.TipoSimbolo.FLOAT;
    }

    /**
     * Setea el nuevo valor String
     * @param valorString
     */
    public void setValorString(String valorString) {
        this.valorString = valorString;
        this.tipo = Simbolo.TipoSimbolo.TEXT;
    }

    /**
     * Setea el nuevo valor Polinomio
     * @param polinomio
     */
    public void setValorPolinomio(Polinomio polinomio)
    {
        this.valorPolinomio = polinomio;
        this.tipo = Simbolo.TipoSimbolo.POLYNOMIAL;
    }

    public String imprimir()
    {
        switch (this.tipo)
        {
            case TEXT:
                return this.valorString;
            case INT:
                return String.valueOf(this.valorInteger);
            case FLOAT:
                return Float.toString(this.valorFloat);
            case POLYNOMIAL:
                return this.valorPolinomio.toString();
            default:
                return "";
        }
    }





}

