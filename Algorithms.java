/**
 * @Purpose: The Algorithms class contains the two algorithms you have to implement  
 * Do NOT modify the names and signatures of the two algorithm methods
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author 
 *
 **/

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

	/**
	 * This method is used to implement the next fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests(shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e.
	 *         place all the shapes). e.g. if you pass a "shapes" list that has
	 *         two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
	 *         of sheets should show us all the information needed (e.g. that
	 *         one sheet is used, this sheet has one shelf and this shelf has
	 *         two shapes in it). In the test program, you can use the returned
	 *         list to retrieve the total number of sheets used.
	 **/


	public List<Sheet> nextFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width
		 * of 300 and a height of 250 as specified in the Sheet class)
		 */
		List<Sheet> usedSheets = new ArrayList<Sheet>();
		List<Shelf> usedShelves=new ArrayList<>();

		Sheet sheet=new Sheet();
		usedSheets.add(sheet);
		Shelf shelf=new Shelf();
		sheet.addShelf(shelf);
		usedShelves.add(shelf);
		shelf.place(shapes.get(0));
		for (int i=1;i<shapes.size();i++) {

				if(shapes.get(i).getWidth()<=shelf.getRemainingWidth()&&shelf.getHeight()>=shapes.get(i).getHeight()){//if the shape fits the width and the height of the shelf
					shelf.place(shapes.get(i));

				}else if(shapes.get(i).rotate(shapes.get(i)).getWidth()<=shelf.getRemainingWidth()&&shelf.getHeight()>=shapes.get(i).rotate(shapes.get(i)).getHeight()){//if the rotated shape fits
					shapes.get(i).rotate(shapes.get(i));
					shelf.place(shapes.get(i));

				}
				else if(shapes.get(i).getHeight()<sheet.getRemainingHeight(sheet)){//if the shape's height doesn't exceed the remaining height of the sheet make a new shelf and place the shape
					Shelf newShelf= new Shelf();
					sheet.addShelf(newShelf);
					newShelf.place(shapes.get(i));


				}else if(shapes.get(i).rotate(shapes.get(i)).getHeight()<sheet.getRemainingHeight(sheet)){//if the rotated shape doesn't exceed the remaining height
					shapes.get(i).rotate(shapes.get(i));
					Shelf newShelf= new Shelf();
					usedShelves.add(newShelf);
					shelf=newShelf;
					sheet.addShelf(newShelf);
					newShelf.place(shapes.get(i));

				}else{//start a new sheet
					Sheet newSheet=new Sheet();
					usedSheets.add(newSheet);
					Shelf newShelf=new Shelf();
					usedShelves.add(newShelf);
					shelf=newShelf;
					newSheet.addShelf(newShelf);
					newShelf.place(shapes.get(i));

				}}


			return usedSheets;

	}

	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests (shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e. place
	 *         all the shapes). e.g. if you pass a "shapes" list that has two
	 *         shapes {(w=200,h=200),(w=50,h=100)}, then the returned list of
	 *         sheets should show us all the information needed (e.g. that one
	 *         sheet is used, this sheet has one shelf and this shelf has two
	 *         shapes in it). In the test program, you can use the returned list
	 *         to retrieve the total number of sheets used
	 **/
	public List<Sheet> firstFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width
		 * of 300 and a height of 250 as specified in the Sheet class)
		 */
		List<Sheet> usedSheets = new ArrayList<Sheet>();

		/*
		 * Add in your own code so that the method will place all the shapes
		 * according to FirstFit under the assumptions mentioned in the spec
		 */
		
		return usedSheets;
	}
	public void displayInfo(List<Sheet> sheets){
		int i=1;
		for(Sheet sheet: sheets) {
			System.out.println("\nSheet number "+i+" has "+sheet.getShelves().size()+" shelves.");
			i++;
			int j=1;
			for(Shelf shelf:sheet.getShelves()){
				System.out.println("Shelf number "+j+" has "+shelf.getShapes().size()+" shapes.");
				j++;
				for(Shape shape:shelf.getShapes()){
					System.out.println(shape.toString());
				}
			}
		}
	}

}
