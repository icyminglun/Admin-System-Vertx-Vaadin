package klass.platform.training.login.vaadinflow;

import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;

import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns = "/*", name = "VaadinFlowServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = VaadinloginUI.class, productionMode = false)
public class VaadinFlowServlet extends VaadinServlet { }
