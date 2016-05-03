package ch.hasselba.xpages;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.el.ValueBinding;

import com.ibm.xsp.component.UIViewRootEx2;
import com.ibm.xsp.context.FacesContextExImpl;
import com.ibm.xsp.resource.StyleSheetResource;

public class VaadinComponent extends UIComponentBase {

	private static final long serialVersionUID = 1L;
	private String url;
	private String divId;
	private String vaadindir;
	private String widgetset;
	private String theme;
	private String version;
	private String browserDetailsUrl;
	private String serviceUrl;
	private boolean _isInForm = false;
	private boolean _isInFormSet = false;
	private boolean forceResize;
	private boolean _isForceResizeSet = false;
	private boolean _isCSSSet = false;

	public VaadinComponent() {
		super();

	}

	@Override
	public String getFamily() {
		return "ch.hasselba.xpages";
	}

	@Override
	public void encodeBegin(FacesContext facesContext) throws IOException {
		ResponseWriter writer = facesContext.getResponseWriter();

		if (!_isInFormSet) {
			_isInForm = isInForm(this);
			_isInFormSet = true;
		}

		if (_isInForm) {
			throw new RuntimeException("Vaadin Component is inside a xp:form element.");
		}

		if (getForceResize()) {
			if (!_isCSSSet) {
				FacesContextExImpl fc = (FacesContextExImpl) FacesContextExImpl.getCurrentInstance();
				UIViewRootEx2 uiRoot = (UIViewRootEx2) fc.getViewRoot();

				StyleSheetResource styleRes = new StyleSheetResource();
				styleRes.setComponent(uiRoot);
				styleRes.setContents("html, body {height:100%;margin:0;}");
				uiRoot.addResource(styleRes);
				_isCSSSet = true;
			}
		}
		try {
			String html = getHTMLTemplate();
			writer.write(html);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getVersion() {
		if (this.version != null) {
			return this.version;
		}

		ValueBinding vb = getValueBinding("version");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUrl() {
		if (this.url != null) {
			return this.url;
		}

		ValueBinding vb = getValueBinding("url");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean getForceResize() {
		if (this._isForceResizeSet) {
			return this.forceResize;
		}

		this._isForceResizeSet = true;

		ValueBinding vb = getValueBinding("forceResize");
		if (vb != null) {
			return (Boolean) vb.getValue(getFacesContext());
		}

		return false;
	}

	public void setForceResize(boolean forceResize) {
		this.forceResize = forceResize;
	}

	public String getDivId() {
		if (this.divId != null) {
			return this.divId;
		}

		ValueBinding vb = getValueBinding("divId");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;
	}

	public void setDivId(String divId) {
		this.divId = divId;
	}

	public String getVaadindir() {
		if (this.vaadindir != null) {
			return this.vaadindir;
		}

		ValueBinding vb = getValueBinding("vaadindir");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;
	}

	public void setVaadindir(String vaadindir) {
		this.vaadindir = vaadindir;
	}

	public String getWidgetset() {
		if (this.widgetset != null) {
			return this.widgetset;
		}

		ValueBinding vb = getValueBinding("widgetset");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;
	}

	public void setWidgetset(String widgetset) {
		this.widgetset = widgetset;
	}

	public String getTheme() {
		if (this.theme != null) {
			return this.theme;
		}

		ValueBinding vb = getValueBinding("theme");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getBrowserDetailsUrl() {
		if (this.browserDetailsUrl != null) {
			return this.browserDetailsUrl;
		}

		ValueBinding vb = getValueBinding("browserDetailsUrl");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;
	}

	public void setBrowserDetailsUrl(String browserDetailsUrl) {
		this.browserDetailsUrl = browserDetailsUrl;
	}

	public String getServiceUrl() {
		if (this.serviceUrl != null) {
			return this.serviceUrl;
		}

		ValueBinding vb = getValueBinding("serviceUrl");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	@Override
	public Object saveState(FacesContext fc) {
		Object[] obj = new Object[14];
		obj[0] = super.saveState(fc);
		obj[1] = this.url;
		obj[2] = this.divId;
		obj[3] = this.vaadindir;
		obj[4] = this.widgetset;
		obj[5] = this.theme;
		obj[6] = this.version;
		obj[7] = this.browserDetailsUrl;
		obj[8] = this.serviceUrl;
		obj[9] = this._isInForm;
		obj[10] = this._isInFormSet;
		obj[11] = this.forceResize;
		obj[12] = this._isForceResizeSet;
		obj[13] = this._isCSSSet;
		return obj;
	}

	@Override
	public void restoreState(FacesContext fc, Object obj) {
		Object[] values = (Object[]) obj;
		super.restoreState(fc, values[0]);
		this.url = ((String) values[1]);
		this.divId = ((String) values[2]);
		this.vaadindir = ((String) values[3]);
		this.widgetset = ((String) values[4]);
		this.theme = ((String) values[5]);
		this.version = ((String) values[6]);
		this.browserDetailsUrl = ((String) values[7]);
		this.serviceUrl = ((String) values[8]);
		this._isInForm = ((Boolean) values[9]);
		this._isInFormSet = ((Boolean) values[10]);
		this.forceResize = ((Boolean) values[11]);
		this._isForceResizeSet = ((Boolean) values[12]);
		this._isCSSSet = ((Boolean) values[13]);
	}

	private String getHTMLTemplate() {
		String result = "";

		result += "<div id=\"${divId}\" class=\"v-app ${theme}\">\n";
		result += "	    <div class=\"v-app-loading\"></div>\n";
		result += "	    <noscript>\n";
		result += "	        You have to enable javascript in your browser to use an application built with Vaadin.\n";
		result += "	    </noscript>\n";
		result += "	</div>\n";
		result += "\n";
		result += "	<script type=\"text/javascript\" src=\"${vaadinDir}vaadinBootstrap.js?v=${vaadinVersion}\"></script>\n";
		result += "\n";
		result += "	<script type=\"text/javascript\">//<![CDATA[\n";
		result += "	    vaadin.initApplication(\"${divId}\", {\n";
		result += "	        \"theme\": \"${theme}\",\n";
		result += "	        \"versionInfo\": {\n";
		result += "	            \"vaadinVersion\": \"${vaadinVersion}\"\n";
		result += "	        },\n";
		result += "	        \"widgetset\": \"${widgetset}\",\n";
		result += "	        \"comErrMsg\": {\n";
		result += "	            \"caption\": \"Communication problem\",\n";
		result += "	            \"message\": \"Take note of any unsaved data, and <u>click here</u> or press ESC to continue.\",\n";
		result += "	            \"url\": null\n";
		result += "	        },\n";
		result += "	        \"authErrMsg\": {\n";
		result += "	            \"caption\": \"Authentication problem\",\n";
		result += "	            \"message\": \"Take note of any unsaved data, and <u>click here</u> or press ESC to continue.\",\n";
		result += "	            \"url\": null\n";
		result += "	        },\n";
		result += "	        \"sessExpMsg\": {\n";
		result += "	            \"caption\": \"Session Expired\",\n";
		result += "	            \"message\": \"Take note of any unsaved data, and <u>click here</u> or press ESC key to continue.\",\n";
		result += "	            \"url\": null\n";
		result += "	        },\n";
		result += "	        \"vaadinDir\": \"${vaadinDir}\",\n";
		result += "	        \"debug\": true,\n";
		result += "	        \"standalone\": false,\n";
		result += "	        \"heartbeatInterval\": 300,\n";
		result += "	        \"browserDetailsUrl\": \"${browserDetailsUrl}\",\n";
		result += "	        \"serviceUrl\": \"${serviceUrl}\"\n";
		result += "	    });\n";
		result += "//]]></script>";

		// fill HTML Template variables
		String divId = isEmpty(getDivId()) ? url.substring(1).replaceAll("/", "-") : getDivId();
		String context = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + url;

		result = result.replace("${divId}", divId);
		result = result.replace("${theme}", isEmpty(getTheme()) ? "valo" : getTheme());
		result = result.replace("${vaadinVersion}", getVersion());
		result = result.replace("${widgetset}", isEmpty(getWidgetset()) ? "com.vaadin.DefaultWidgetSet"
				: getWidgetset());
		result = result.replace("${vaadinDir}", isEmpty(getVaadindir()) ? context + "VAADIN/" : getVaadindir());
		result = result.replace("${browserDetailsUrl}", isEmpty(getBrowserDetailsUrl()) ? context
				: getBrowserDetailsUrl());
		result = result.replace("${serviceUrl}", isEmpty(getServiceUrl()) ? context : getServiceUrl()); // 

		return result;

	}

	/**
	 * checks if a String is empty
	 * 
	 * @param toTest
	 *            the String to test
	 * @return true, if the String is empty
	 */
	private static boolean isEmpty(final String toTest) {
		if (toTest == null || "".equals(toTest))
			return true;

		return false;
	}

	/**
	 * tests if a component is inside a xp:form
	 * 
	 * @param uiComponent
	 *            the leaf to start with
	 * @return true, if component is inside
	 */
	private static boolean isInForm(UIComponent uiComponent) {

		if (uiComponent == null)
			return false;

		if (uiComponent instanceof com.ibm.xsp.component.xp.XspForm)
			return true;

		return isInForm(uiComponent.getParent());

	}

}