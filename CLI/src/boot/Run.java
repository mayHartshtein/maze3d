package boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.Controller;
import controller.MyController;
import model.Model;
import model.MyModel;
import view.MyView;
import view.View;

public class Run {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		MyModel myModel= new MyModel();
		MyView myView= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));
		MyController myController= new MyController(myModel,myView);
		
		myModel.setC(myController);
		myView.setC(myController);
		myView.V_start();
		
		
		/*
		Controller controller = new MyController();
		Model model = new MyModel(controller);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		View view = new MyView(controller, in, out);
		
		controller.setModel(model);
		controller.setView(view);
		
		view.V_start();
		
		*/

	}

}
