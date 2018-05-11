import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet1 {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		UserBean details=new InsuranceDAO().isUser(uid,pwd);
		out.print("Pass");
		if(details.getRole()=="")
		{
			out.print("Sorry UserName or Password Error!");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request,response);
			
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("Uname", details.getUsername());
			if(details.getRole().equals("user"))
			{
				response.sendRedirect("Mainmenu_user.jsp");
			}
			else if(details.getRole().equals("admin"))
			{
				response.sendRedirect("Mainmenu_admin.jsp");
			}
		}
		
	}

}


