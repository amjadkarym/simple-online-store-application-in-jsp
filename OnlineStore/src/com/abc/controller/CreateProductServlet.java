package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.ProductModel;
import com.abc.model.ProductTypeModel;
import com.abc.services.ManageServices;

/**
 * Servlet implementation class CreateProductServlet
 */
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
		ManageServices manageServices = new ManageServices();
		String UPLOAD_IMAGE_DIR = "E:/AndroidWorkspace/OnlineStore/WebContent/images/products";
//		PrintWriter out = response.getWriter();
//		MultipartRequest m = new MultipartRequest(request, UPLOAD_IMAGE_DIR);

//		m.getParameter("create");

		ProductModel product = new ProductModel();
		ArrayList<ProductTypeModel> listProducts = null;
		String paramName = request.getParameter("create");
		// String url =
		// request.getServletContext().getRealPath("\") + "views\\layout\\header.jsp";
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/views/layout/");

		if (paramName != null && paramName.equals("Create")) {
			// byte[] imageInByte;
			// BufferedImage originalImage = ImageIO.read(new File(
			// "C:/Users/Amjad/Desktop/Images/sample_0.jpg"));
			// ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// ImageIO.write(originalImage, "jpg", baos);
			// baos.flush();
			// imageInByte = baos.toByteArray();
			// product.setImageInByte(imageInByte);
			// System.out.println(imageInByte.toString());
			// baos.close();

			ProductTypeModel productType = new ProductTypeModel();
			String name = request.getParameter("name");
//			String image = request.getParameter("imageFile");
			int status = Integer.parseInt(request.getParameter("status"));

			product.setName(name);
			if (request.getParameter("listProducts") != null
					&& !request.getParameter("listProducts").equals("")) {
				productType.setId(Integer.parseInt(request
						.getParameter("listProducts")));
				product.setType(productType);
			}
			product.setStatus(status);
			
			manageServices.getProductServices().createProduct(product);
//			ProductServices.createProduct(product);
			ProductModel getProduct = null;
//			getProduct = ProductServices.getProduct(product);
			getProduct = manageServices.getProductServices().getProduct(product);
			request.setAttribute("product", getProduct);

//			if (ServletFileUpload.isMultipartContent(request)) {
//				try {
//					List<FileItem> multiparts = new ServletFileUpload(
//							new DiskFileItemFactory())
//							.parseRequest((RequestContext) request);
//					for (FileItem item : multiparts) {
//						if (!item.isFormField()) {
//							String imageName = new File(item.getName())
//									.getName();
//							item.write(new File(UPLOAD_IMAGE_DIR
//									+ File.separator + imageName));
//						}
//					}
//
//					// File uploaded successfully
//					request.setAttribute("message",
//							"File Uploaded Successfully");
//
//				} catch (Exception ex) {
//					request.setAttribute("message",
//							"File Upload Failed due to " + ex);
//
//				}
//			}

			
			
			request.getRequestDispatcher("views/products/view.jsp").forward(
					request, response);
		} else {
//			listProducts = ProductTypeServices.getProductTypes();
			listProducts = manageServices.getProductTypeServices().getProductTypes();
			request.setAttribute("listProducts", listProducts);
			request.setAttribute("product", product);
			request.setAttribute("fullPath", fullPath);
			// response.sendRedirect("views/products/create.jsp");
			request.getRequestDispatcher("views/products/create.jsp").forward(
					request, response);
		}
	}
}
