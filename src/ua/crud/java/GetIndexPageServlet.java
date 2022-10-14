package ua.crud.java;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class GetIndexPageServlet extends HttpServlet {
	private final static String INDEX = "/WEB-INF/view/index.jsp";
	private List<ImmovableModel> immovable;

	@Override
	public void init() throws ServletException {
		immovable = new CopyOnWriteArrayList<>();
		immovable.add(new ImmovableModel("WolfStreet 9A", 2009, 790000.0, 3, 61.0, 1, 1));
		immovable.add(new ImmovableModel("WolfStreet 10A", 2009, 790000.0, 3, 62.0, 1, 1));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("immovables", immovable);
		req.getRequestDispatcher(INDEX).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF8");

		if (!requestIsValid(req)) {
			doGet(req, resp);
		}

		final String adress = req.getParameter("adress");
		final String age = req.getParameter("age");
		final String price = req.getParameter("price");
		final String countOfRooms = req.getParameter("countOfRooms");
		final String countOfSquareMeters = req.getParameter("countOfSquareMeters");
		final String floor = req.getParameter("floor");
		final String elevator = req.getParameter("elevator");

		final ImmovableModel rs = new ImmovableModel(adress, Integer.valueOf(age), Double.valueOf(price),
				Integer.valueOf(countOfRooms), Double.valueOf(countOfSquareMeters), Integer.valueOf(floor),
				Integer.valueOf(elevator));

		immovable.add(rs);

		doGet(req, resp);
	}

	private boolean requestIsValid(final HttpServletRequest req) {

		final String adress = req.getParameter("adress");
		final String age = req.getParameter("age");
		final String price = req.getParameter("price");
		final String countOfRooms = req.getParameter("countOfRooms");
		final String countOfSquareMeters = req.getParameter("countOfSquareMeters");
		final String floor = req.getParameter("floor");
		final String elevator = req.getParameter("elevator");

		return adress != null && adress.length() > 0 && age != null && age.length() > 0 && age.matches("[+]?\\d+")
				&& price.length() > 0 && price != null && price.matches("[+]?\\d+") && countOfRooms != null
				&& countOfRooms.length() > 0 && countOfRooms.matches("[+]?\\d+") && countOfSquareMeters.length() > 0
				&& countOfSquareMeters != null && countOfSquareMeters.matches("[+]?\\d+") && floor.length() > 0
				&& floor.matches("[+]?\\d+") && floor != null && elevator.length() > 0 && elevator != null
				&& elevator.matches("[+]?\\d+");
	}

}
