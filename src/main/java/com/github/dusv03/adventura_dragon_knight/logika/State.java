/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dusv03.adventura_dragon_knight.logika;

/**
 *
 * @author vladi
 */
public class State {
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
private static boolean killableGhost;
private static int mageS;
private static int spriteS;
private static int blacksmithS;

//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

/***************************************************************************
* Vrátí informaci o tom, je-li duch zranitelný.
*
* @return Je-li podložena, vrátí {@code true}, jinak vrátí {@code false}
*/
static boolean isGhostKillable()
{
return killableGhost;
}

static int getmageS()
{
return mageS;
}

static int getspriteS()
{
return spriteS;
}

static int getblacksmithS()
{
return blacksmithS;
}
/***************************************************************************
* Nastaví informaci o tom, je-li duch zranitelný.
*
* @param iceboxSupported Nastavovaná hodnota
*/
static void setKillableGhost(boolean killableGhost)
{
State.killableGhost = killableGhost;
}

static void setmageS(int state)
{
mageS = state;
}

static void setspriteS(int state)
{
spriteS = state;
}

static void setblacksmithS(int state)
{
blacksmithS = state;
}
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

/***************************************************************************
* Inicializuje všechny příznaky, které udržují informace
* o aktuálním stavu hry a jejích součástí.
*/
static void initialize()
{
killableGhost = false;
mageS         = 1;
spriteS       = 1;
blacksmithS   = 1;
}



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

/***************************************************************************
* Soukromý konstruktor zabraňující vytvoření instance.
*/
private State()
{
}



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
  
}
