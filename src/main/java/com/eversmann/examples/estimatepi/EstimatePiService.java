package com.eversmann.examples.estimatepi;

/*
 * Estimates pi using the fact that the probability, p, that 2 random numbers are 
 * coprimes is defined as:
 * 		p = 6 / (pi^2)
 * 
 * Using that fact pi can be defined as:
 * 		pi = sqrt( 6/p )
 * 
 * The probability can be found by testing a set of random numbers:
 * 		pi = sqrt ( 6 / (found_coprimes/tries) )
 * 				or
 * 		pi = sqrt ( 6 * tries / found_coprimes )
 * 
 */
public class EstimatePiService {
	
	double estimatePi(int numTries, int maxNumber) {
    	System.out.println("EstimatePiService.estimatePi");
		int numFoundCoprimes = 0;
		for (int i=0; i<numTries; i++) {
			if (gcd (randomWithMax(maxNumber), randomWithMax(maxNumber))==1) {
				numFoundCoprimes++;
			}
		}
		return Math.sqrt(6.0 * (double)numTries / (double)numFoundCoprimes);
	}
	
	private static int gcd(int a, int b) {
		return (b==0 ? a : gcd (b, a%b));
	}
	
	private static int randomWithMax(int maxNumber) {
		return (int)(Math.random()*maxNumber);
	}

}
