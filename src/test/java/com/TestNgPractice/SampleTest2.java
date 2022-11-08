package com.TestNgPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest2 
{
		@Test
		public void aaaa() {
			System.out.println("=======TestStart==========");
			
			Assert.assertEquals(false, true);
			System.out.println("=============TestEnd===========");
			
		}
}
