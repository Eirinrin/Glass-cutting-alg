import org.junit.*;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

/**
 * @Purpose: The CorrectnessTest class is used to validate the correctness of
 *           the implemented algorithms. You can add additional methods if you
 *           need
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 */

public class CorrectnessTest {

	@Test
	public void testWidthNF(){
		Algorithms a=new Algorithms();
		Generator g=new Generator();
 		List<Sheet> sheetList = a.nextFit(g.generateShapeList(10));
		a.displayInfo(sheetList);
		for(Sheet sheet:sheetList){
			for(Shelf shelf:sheet.getShelves()){
				assertTrue(shelf.getWidth()<=sheet.getWidth());
			}
		}

	}
	@Test
	public void testHeightNF(){
		Algorithms a=new Algorithms();
		Generator g=new Generator();
		List<Sheet> sheetList = a.nextFit(g.generateShapeList(10));
		for(Sheet sheet:sheetList){
			assertTrue(sheet.allShelvesHeight()<sheet.getHeight());
		}
	}

	@Test
	public void shelfArrangement(){
		Algorithms a=new Algorithms();
		Sheet s =new Sheet();
		Generator g=new Generator();
		List<Sheet> sheetList = a.nextFit(g.generateShapeList(10));
		for(Sheet sheet:sheetList){
			for(Shelf shelf:sheet.getShelves()){
				for(Shape shape:shelf.getShapes()){
					assertTrue(shelf.getHeight()>=shape.getHeight());

				}
			}
		}
	}
}