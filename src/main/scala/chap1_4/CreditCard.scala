class CreditCard(var number: Int, var creditLimit: Int)
//$ scalac CreditCard.scala
//$ javap -private CreditCard
//Compiled from "CreditCard.scala"
//public class CreditCard {
//  private int number;
//  private int creditLimit;
//  public int number();
//  public void number_$eq(int);
//  public int creditLimit();
//  public void creditLimit_$eq(int);
//  public CreditCard(int, int);
//}

