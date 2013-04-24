package uk.co.tpplc.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SecretPhraseCheckerServlet extends HttpServlet {

	public static final String PASSPHRASE_PARAMETER_NAME = "passphrase";
	public static final String CORRECT_PASSPHRASE = "supercalifragilisticexpialidocious";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String passphrase = request.getParameter(PASSPHRASE_PARAMETER_NAME);
		
		if(checkPassphraseIsValid(passphrase)){
			request.getSession().setAttribute("goodegg", "yes");
		}else{
			request.getSession().removeAttribute("goodegg");
		}
		request.getRequestDispatcher("/index.jsp");
	}

	public boolean checkPassphraseIsValid(String passPhrase) {
		return CORRECT_PASSPHRASE.equals(passPhrase);
	}

}
