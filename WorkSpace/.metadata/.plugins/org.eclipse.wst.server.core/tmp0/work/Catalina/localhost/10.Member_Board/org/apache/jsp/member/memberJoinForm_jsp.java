/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.72
 * Generated at: 2021-12-17 05:16:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memberJoinForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Member Join Form</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery/jquery-3.6.0.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var idCheck = 0;\r\n");
      out.write("var pwCheck = 0;\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("	//ID 유효성 검사\r\n");
      out.write("	$(\"#member_id\").keyup(function(){\r\n");
      out.write("		var id = document.querySelector(\"#member_id\").value;		\r\n");
      out.write("		var regId = /^[a-z0-9]{8,15}$/;\r\n");
      out.write("		\r\n");
      out.write("		if(!regId.test(id)){\r\n");
      out.write("			var msg = \"영문 소문자와 숫자 8 ~15 이내로 입력해주세요!\";\r\n");
      out.write("			$(\"#idCheck\").text(msg);\r\n");
      out.write("			$(\"#idCheck\").css(\"color\", \"red\");\r\n");
      out.write("			$(\"#member_id\").focus();\r\n");
      out.write("		}else {\r\n");
      out.write("			//ID 중복검사\r\n");
      out.write("			var check = true;\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				dataType : \"json\",\r\n");
      out.write("				url : \"member/idList.jsp\",\r\n");
      out.write("				success : function(data){\r\n");
      out.write("					$.each(data, function(key, value){\r\n");
      out.write("						if(id == value.member_id){\r\n");
      out.write("							check = false;\r\n");
      out.write("						}\r\n");
      out.write("					}); //each()\r\n");
      out.write("					fnCheck(check);\r\n");
      out.write("				},\r\n");
      out.write("				error : function(){alert(\"ID 중복 검사 오류!\");}\r\n");
      out.write("			}); //ajax()\r\n");
      out.write("		} //else\r\n");
      out.write("	}); //idkeyup()\r\n");
      out.write("	\r\n");
      out.write("	//비밀번호 유효성 검사\r\n");
      out.write("	$(\"#member_pw, #member_pw_check\").keyup(function(){\r\n");
      out.write("		var pw = $(\"#member_pw\").val();\r\n");
      out.write("		var num = pw.search(/[0-9]/g);\r\n");
      out.write("		var eng = pw.search(/[a-zA-Z]/ig);\r\n");
      out.write("		var spe = pw.search(/[~!@#$%^&*]/gi);\r\n");
      out.write("		\r\n");
      out.write("		if(pw.search(/\\s/g) != -1){\r\n");
      out.write("			var msg = \"비밀번호는 공백문자를 사용할 수 없습니다!\";\r\n");
      out.write("			$(\"#pwCheck\").text(msg);\r\n");
      out.write("			$(\"#pwCheck\").css(\"color\", \"red\");\r\n");
      out.write("			$(\"#member_pw\").focus();\r\n");
      out.write("		} else if(pw.length < 8 || pw.length > 15){\r\n");
      out.write("			var msg = \"비밀번호는 8 ~ 15 이내로 입력해주세요!\";\r\n");
      out.write("			$(\"#pwCheck\").text(msg);\r\n");
      out.write("			$(\"#pwCheck\").css(\"color\", \"red\");\r\n");
      out.write("			$(\"#member_pw\").focus();\r\n");
      out.write("		} else if((num < 0 && eng < 0) ||(eng < 0 && spe< 0) || (num < 0 && spe < 0)){\r\n");
      out.write("			var msg = \"영문자, 숫자, 특수문자를 혼합하여 입력해주세요!\";\r\n");
      out.write("			$(\"#pwCheck\").text(msg);\r\n");
      out.write("			$(\"#pwCheck\").css(\"color\", \"red\");\r\n");
      out.write("			$(\"#member_pw\").focus();\r\n");
      out.write("		} else {\r\n");
      out.write("			var msg = \"사용가능한 비밀번호입니다!\";\r\n");
      out.write("			$(\"#pwCheck\").text(msg);\r\n");
      out.write("			$(\"#pwCheck\").css(\"color\", \"blue\");\r\n");
      out.write("			\r\n");
      out.write("			var pwReCheck = $(\"#member_pw_check\").val();\r\n");
      out.write("			if(pw != pwReCheck){\r\n");
      out.write("				var msg = \"비밀번호가 일치하지 않습니다!\";\r\n");
      out.write("				$(\"#pwReCheck\").text(msg);\r\n");
      out.write("				$(\"#pwReCheck\").css(\"color\", \"red\");				\r\n");
      out.write("			} else {\r\n");
      out.write("				var msg = \"비밀번호가 일치합니다!\";\r\n");
      out.write("				$(\"#pwReCheck\").text(msg);\r\n");
      out.write("				$(\"#pwReCheck\").css(\"color\", \"blue\");\r\n");
      out.write("				pwCheck = 1;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	});//pwkeyup()}\n");
      out.write("});//ready()\r\n");
      out.write("function fnCheck(check){\r\n");
      out.write("	if(!check){\r\n");
      out.write("		var msg = \"사용중인 아이디입니다.\";\r\n");
      out.write("		$(\"#idCheck\").text(msg);\r\n");
      out.write("		$(\"#idCheck\").css(\"display\", \"block\");\r\n");
      out.write("		$(\"#idCheck\").css(\"color\", \"red\");\r\n");
      out.write("	} else {\r\n");
      out.write("		var msg = \"사용가능한 아이디 입니다.\";\r\n");
      out.write("		$(\"#idCheck\").text(msg);\r\n");
      out.write("		$(\"#idCheck\").css(\"display\", \"block\");\r\n");
      out.write("		$(\"#idCheck\").css(\"color\", \"blue\");\r\n");
      out.write("		idCheck = 1;\r\n");
      out.write("	}\r\n");
      out.write("}//fnCheck()\r\n");
      out.write("\r\n");
      out.write("function fnSubmit(){\r\n");
      out.write("	if(idCheck == 0 || pwCheck ==0){\r\n");
      out.write("		alert(\"아이디나 비밀번호가 형식에 맞지 않습니다!\");\r\n");
      out.write("		return false;\r\n");
      out.write("	} else {\r\n");
      out.write("		var msg = \"입력하신 내용으로 회원가입이 됩니다\";\r\n");
      out.write("		msg +=\"\\n가입하시겠습니까?\";\r\n");
      out.write("		if(confirm(msg)){\r\n");
      out.write("			return true;\r\n");
      out.write("		} else {\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function fnReset(){\r\n");
      out.write("	var msg = \"작성하신 내용이 초기화 됩니다.\";\r\n");
      out.write("	msg += \"\\n다시 작성하시겠습니까?\"\r\n");
      out.write("	if(confirm(msg)){\r\n");
      out.write("		return true;\r\n");
      out.write("	}else {\r\n");
      out.write("		return false;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<h3>[회원가입]</h3>\r\n");
      out.write("<form action=\"memberJoinAction.me\" method=\"post\" onsubmit=\"return fnSubmit()\" onreset=\"return fnReset()\">\r\n");
      out.write("<table border=\"1\" style=\"width: 50%\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>아이디</th>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type=\"text\" name=\"member_id\" id=\"member_id\" required=\"required\"/><br/>\r\n");
      out.write("			<span id=\"idCheck\"></span><!-- ID 유효성 검사 및 중복여부 -->\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>	\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>비밀번호</th>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type=\"password\" name=\"member_pw\" id=\"member_pw\" required=\"required\"/><br/>\r\n");
      out.write("			<span id=\"pwCheck\"></span><!-- ID 유효성 검사 및 중복여부 -->\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>		\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>비밀번호 확인</th>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type=\"password\" name=\"member_pw_check\" id=\"member_pw_check\" required=\"required\"/><br/>\r\n");
      out.write("			<span id=\"pwReCheck\"></span><!-- ID 유효성 검사 및 중복여부 -->\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>이름</th>\r\n");
      out.write("		<td><input type=\"text\" name=\"member_name\" id=\"member_name\" required=\"required\"/></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>나이</th>\r\n");
      out.write("		<td><input type=\"number\" name=\"member_age\" id=\"member_age\" required=\"required\"/></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>성별</th>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type=\"radio\" name=\"member_gender\" id=\"member_gender\" value=\"남\" checked=\"checked\"/>남자\r\n");
      out.write("			<input type=\"radio\" name=\"member_gender\" id=\"member_gender\" value=\"여\" />여자\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>이메일</th>\r\n");
      out.write("		<td><input type=\"text\" name=\"member_email\" id=\"member_email\" maxlength=\"30\"/></td>\r\n");
      out.write("	</tr>		\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td colspan=\"2\" align=\"center\">\r\n");
      out.write("			<input type=\"submit\" value=\"회원가입\"/>\r\n");
      out.write("			<input type=\"reset\" value=\"다시작성\"/>\r\n");
      out.write("			<input type=\"button\" value=\"로그인\" onclick=\"location.href='memberLogin.me'\"/>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>		\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
