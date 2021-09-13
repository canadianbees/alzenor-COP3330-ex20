/*
 *  UCF COP3330 Fall 2021 Store Class file
 *  Copyright 2021 Celina Alzenor
 */

package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Store
{
    private final int orderAmt;
    private final String state;

    public Store()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the order amount? ");
        this.orderAmt = input.nextInt();

        System.out.print("What is the state? ");
        this.state = input.next();


    }

    //determines if tax is added and calculates it based on state, and if needed county.
    public void TaxCalc()
    {
        double tax,total,percent;
        DecimalFormat round = new DecimalFormat("##0.00");

        //if user is in wisconsin
        if(this.state.matches("WI") || this.state.matches("wi") || this.state.matches("Wi") || this.state.matches("wI"))
        {
            //asks user what county they are in
            Scanner input = new Scanner(System.in);
            System.out.print("What is the county? ");
            String county = input.next();

            //if they are in Dunn of Eau Claire, additional county tax is added
            if(county.matches("Dunn"))
            {
                 percent = ((5.0+.004)/100);
                 tax = (this.orderAmt*percent);
            }

            else if(county.matches("Eau Claire"))
            {
                 percent = ((5.0+.005)/100);
                 tax = (this.orderAmt*percent);
            }

            //if they are in another county, regular state tax
            else
            {
                percent = 5.0/100;
                tax = (this.orderAmt*percent);
            }
        }

        //if user is in illinois
        else if(this.state.matches("IL"))
        {
            percent = (8.0/100);
            tax = (this.orderAmt*percent);
        }

        //if user is in another state
        else
        {
            total = this.orderAmt;
            System.out.println("The total is $"+round.format(total)+".");
            return;
        }

        total = tax+this.orderAmt;
        System.out.println("The tax is $"+round.format(tax)+"\nThe total is $"+round.format(total)+".");

    }
}
