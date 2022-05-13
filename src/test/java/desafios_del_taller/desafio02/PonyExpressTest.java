package desafios_del_taller.desafio02;

import org.junit.Assert;
import org.junit.Test;

public class PonyExpressTest {

	@Test
	public void test1Jinete() {
		Assert.assertEquals(1, PonyExpress.jinetes(new int[] {18, 15}));
	}
	
	@Test
	public void test2Jinetes() {
		Assert.assertEquals(2, PonyExpress.jinetes(new int[] {43, 23, 40, 13}));
	}
	
	@Test
	public void test3Jinetes() {
		Assert.assertEquals(3, PonyExpress.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
		Assert.assertEquals(3, PonyExpress.jinetes(new int[] {51, 51, 51}));
	}
	
	@Test
	public void test4Jinetes() {
		Assert.assertEquals(4, PonyExpress.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
		Assert.assertEquals(4, PonyExpress.jinetes(new int[] {100, 100, 100, 49, 25}));
	}

	@Test
	public void test10Jinetes() {
		Assert.assertEquals(10, PonyExpress.jinetes(new int[] {100, 100, 100, 49, 25, 100, 100, 39, 29, 100, 52, 53}));
	}
}
