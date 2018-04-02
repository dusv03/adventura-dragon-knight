package com.github.dusv03.adventura_dragon_knight.logika;

 

/*******************************************************************************
 * Třída Vec ...
 *
 *@author     Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015
 */
public class Vec
{
	
	//STATICKÉ TŘÍDNÍ ATRIBUTY
	
	 /** Váha nepřenositelných h-objektů. */
    private static final int HEAVY = Batoh.KAPACITA + 1;

    /** Příznak standardního přenositelného h-objektu. */
    static final char STANDARD = '1';

    /** Příznak zabitelného objektu */
    static final char KILLABLE = '#';

    /** Příznak nepřenositelnosti h-objektu. */
    static final char NOT_MOVABLE = '0';

    /** Příznak alkoholického nápoje. */
    static final char COMMUNICATIVE = '@';
    
//== Datové atributy (statické i instancí)======================================
    private String jmeno;
    private final boolean SMRTELNOST;
    private final boolean KOMUNIKATIVITA;
    private int váha;
    private int stav;

//##############################################################################
//== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *
     */
    public Vec (String jmeno) {
		this.jmeno = jmeno.substring(1);
        boolean eSMRTELNOST = false;
        boolean eKOMUNIKATIVITA = false;
        váha = HEAVY;
        stav = 1;

        char prefix = jmeno.charAt(0);
        switch (prefix)
        {
        case STANDARD:
        váha = 1;
        break;

        case KILLABLE:
        eSMRTELNOST = true;
        break;

        case NOT_MOVABLE:
        break;

        case COMMUNICATIVE:
        eKOMUNIKATIVITA = true;
        break;
        
        default:
        throw new RuntimeException(
        "\nNeznámá hodnota prefixu: «" + prefix + '»');
        }
        SMRTELNOST = eSMRTELNOST;
        KOMUNIKATIVITA = eKOMUNIKATIVITA;
	}



//== Nesoukromé metody (instancí i třídy) ===============================================
//== Soukromé metody (instancí i třídy) ===========================================
    public String getJmeno () {
		return jmeno;
	}
    public int getWeight()
    {
        return váha;
    }
    
    public void setWeight(int weight)
    {
        váha = weight;
    }  

    public boolean getSmrtelnost()
    {
        return SMRTELNOST;
    }
    
    public boolean getKOMUNIKATIVITA()
    {
        return KOMUNIKATIVITA;
    }
    
    public int getStav()
    {
        return stav;
    }
    
    public void setStav(int stav2)
    {
        stav = stav2;
    }
    
    @Override
    public String toString() {
     return getJmeno();
    }
}

