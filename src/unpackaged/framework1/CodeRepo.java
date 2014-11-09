/*
* Class:	CodeRepo - internal code repo. Remove before deploying final app
* Version:	 1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014
* Copyright notice
*/	
public class CodeRepo {
	/*----------------------------------------------------------*/
	/* Loops */
	// FOR loop
	for (int i = 0; i < 10; i++) {
		   // do stuff, sometimes using i,
		   // but usually not changing i
		} 

	// 1D ARRAY loop
	for (int j = 0; j < intArray.length; j++) {
		   intArray[j] = j * 10;
		   System.out.println(intArray[j]);
		}

	// Loop thru multiple arrays of same size
	for (int i = 0; i < intArrayA.length; i++) {
		   intArrayA[i] = intArrayB[i] * 10;
		   System.out.println(intArrayA[i]);
		}

	//NESTED loop
	for (int i = 0; i < 10; i++) {
		   for (int j = 0; j < 100; j++) {
		      System.out.println(i + " x " + j + " = " + i*j);
		   }
		}

	//2D ARRAY loop
	for (int i = 0; i < intArray.length; i++) {
		   for (int j = 0; j < intArray[i].length; j++) {
		      intArray[i][j] = 10;
		      System.out.println(intArray[i][j]);
		   }
		}
	
	// SHIFT array one row down, while avoiding boundary problem
	for (int i = 0; i < arrayA.length; i++) {
		   for (int j = 0; j < arrayA[i].length; j++) {
		      if (i != 0) {
		         arrayB[i][j] = arrayA[i - 1][j];
		      } else {
		         arrayB[i][j] = arrayA[arrayA.length - 1][j];
		      }
		   }
		}

	
	/*----------------------------------------------------------*/
	/* Branching methods */
	
	// IF statement
	if (some condition) { 
		do something; 
	}

	// IF-ELSE statement
	if (condition) {do something;} 
	else {do something else;}

	// Ternary Kung Fu
	//variable = condition?expression1:expression2;
	name = (fileFound==true)?(filename):(defaultName);
	
	// If/else/if ladder - most probably condition at top to max processing speed
	if (condition) 
		statement or {statements;}
	else if (condition) 
		statement or {statements;}
	else if (condition) 
		statement or {statements;}
	else
		statement or {statements;} 

	// Switch statement - more efficient than if/else/if ladder if cases have same probability of occuring or 
	// if/else/if ladder frequently needs to go down past top two options 
	switch (variable) {
	case value1:
		statements1;
		break;
	case value2:
		statements2;
		break;
	case value3:
		statements3;
		break;
	default:
		statements4;
	}

	/*----------------------------------------------------------*/
	
	/*----------------------------------------------------------*/
	
	/*----------------------------------------------------------*/
	
	/*----------------------------------------------------------*/
	
}
