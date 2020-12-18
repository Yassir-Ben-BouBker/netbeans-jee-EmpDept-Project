# netbeans-jee-EmpDept-Project

I use Github in the place of the classroom because of a problem with my computer 
I add the servlet and JSP to the base Code but I encounter a problem that I wasn't able to fix tell now




HTTP Status 500 - Internal Server Error


type Exception report

messageInternal Server Error

descriptionThe server encountered an internal error that prevented it from fulfilling this request.

exception 
javax.servlet.ServletException: Error instantiating servlet class Controller.EDServlet


root cause 
com.sun.enterprise.container.common.spi.util.InjectionException: Error creating managed object for class: class Controller.EDServlet


root cause 
java.lang.IllegalStateException: Exception attempting to inject Remote ejb-ref name=Controller.EDServlet/daoDep,Remote 3.x interface =Dao.DepartementFacade,ejb-link=null,lookup=,mappedName=DepartementFacade,jndi-name=,refType=Session into class Controller.EDServlet: Lookup failed for 'java:comp/env/Controller.EDServlet/daoDep' in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl, java.naming.factory.url.pkgs=com.sun.enterprise.naming}


root cause 
com.sun.enterprise.container.common.spi.util.InjectionException: Exception attempting to inject Remote ejb-ref name=Controller.EDServlet/daoDep,Remote 3.x interface =Dao.DepartementFacade,ejb-link=null,lookup=,mappedName=DepartementFacade,jndi-name=,refType=Session into class Controller.EDServlet: Lookup failed for 'java:comp/env/Controller.EDServlet/daoDep' in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl, java.naming.factory.url.pkgs=com.sun.enterprise.naming}


root cause 
javax.naming.NamingException: Lookup failed for 'java:comp/env/Controller.EDServlet/daoDep' in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl, java.naming.factory.url.pkgs=com.sun.enterprise.naming} [Root exception is javax.naming.NamingException: Exception resolving Ejb for 'Remote ejb-ref name=Controller.EDServlet/daoDep,Remote 3.x interface =Dao.DepartementFacade,ejb-link=null,lookup=,mappedName=DepartementFacade,jndi-name=,refType=Session' .  Actual (possibly internal) Remote JNDI name used for lookup is 'DepartementFacade#Dao.DepartementFacade' [Root exception is javax.naming.NamingException: Lookup failed for 'DepartementFacade#Dao.DepartementFacade' in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl, java.naming.factory.url.pkgs=com.sun.enterprise.naming} [Root exception is javax.naming.NameNotFoundException: DepartementFacade#Dao.DepartementFacade not found]]]


root cause 
javax.naming.NamingException: Exception resolving Ejb for 'Remote ejb-ref name=Controller.EDServlet/daoDep,Remote 3.x interface =Dao.DepartementFacade,ejb-link=null,lookup=,mappedName=DepartementFacade,jndi-name=,refType=Session' .  Actual (possibly internal) Remote JNDI name used for lookup is 'DepartementFacade#Dao.DepartementFacade' [Root exception is javax.naming.NamingException: Lookup failed for 'DepartementFacade#Dao.DepartementFacade' in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl, java.naming.factory.url.pkgs=com.sun.enterprise.naming} [Root exception is javax.naming.NameNotFoundException: DepartementFacade#Dao.DepartementFacade not found]]


root cause 
javax.naming.NamingException: Lookup failed for 'DepartementFacade#Dao.DepartementFacade' in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl, java.naming.factory.url.pkgs=com.sun.enterprise.naming} [Root exception is javax.naming.NameNotFoundException: DepartementFacade#Dao.DepartementFacade not found]


root cause 
javax.naming.NameNotFoundException: DepartementFacade#Dao.DepartementFacade not found


note The full stack traces of the exception and its root causes are available in the GlassFish Server Open Source Edition 4.1.1 logs.
