/*******************************************************************************
 * Copyright (c) 2001, 2008 Oracle Corporation and others. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Oracle Corporation - initial API and implementation
 *******************************************************************************/


package org.eclipse.jst.jsf.common.webxml;


import java.util.Arrays;
import java.util.List;

import org.eclipse.jst.j2ee.common.CommonFactory;
import org.eclipse.jst.j2ee.common.Description;
import org.eclipse.jst.j2ee.common.Listener;
import org.eclipse.jst.j2ee.common.ParamValue;
import org.eclipse.jst.j2ee.webapplication.Filter;
import org.eclipse.jst.j2ee.webapplication.FilterMapping;
import org.eclipse.jst.j2ee.webapplication.Servlet;
import org.eclipse.jst.j2ee.webapplication.ServletMapping;
import org.eclipse.jst.j2ee.webapplication.ServletType;
import org.eclipse.jst.j2ee.webapplication.WebApp;
import org.eclipse.jst.j2ee.webapplication.WebapplicationFactory;
import org.eclipse.jst.j2ee.webapplication.internal.impl.ServletTypeImpl;


/**
 * Web.xml editing utilities for J2EE (Servlet 2.4 and lower versions).
 *
 * @author Debajit Adhikary
 *
 */
public class WebXmlUtilsForJ2EE
{
    /**
     * @param webapp
     * @param servletName
     * @param servletClass
     * @param loadOnStartup
     */
    public static void addServlet (final WebApp webapp,
                                   final String servletName,
                                   final String servletClass,
                                   final String loadOnStartup)
    {
        if (existsServlet(webapp, servletName, servletClass))
            return;

        // Create new servlet

        final Servlet servlet = WebapplicationFactory.eINSTANCE.createServlet();
        servlet.setServletName(servletName);
        servlet.setLoadOnStartup(new Integer(loadOnStartup));

        final ServletType servletType = WebapplicationFactory.eINSTANCE.createServletType();
        servletType.setClassName(servletClass);
        servlet.setWebType(servletType);

        webapp.getServlets().add(servlet);
    }


    /**
     * @param webapp
     * @param servletName
     * @param servletClass
     * @return true if the specified servlet is declared for use in webapp
     */
    public static boolean existsServlet (final WebApp webapp,
                                         final String servletName,
                                         final String servletClass)
    {
        return findServlet(webapp, servletName, servletClass) != null;
    }


    /**
     * @param webapp
     *            Webapp in which to look for
     * @param servletName
     *            Servlet name
     * @param servletClass
     *            Servlet class
     *
     * @return The servlet containing the specified servlet-name and
     *         servlet-class in web.xml
     */
    public static Servlet findServlet (final WebApp webapp,
                                       final String servletName,
                                       final String servletClass)
    {
        for (final Object s : webapp.getServlets())
        {
            final Servlet servlet = (Servlet) s;
            if (servlet.getServletName().equals(servletName)
                    && ((ServletType) servlet.getWebType()).getClassName().equals(servletClass))
            {
                return servlet;
            }
        }

        return null;
    }


    /**
     * @param webApp
     * @param servletClassName
     * @return the servlet or null if not found
     */
    public static Servlet findServlet (final WebApp webApp,
                                       final String servletClassName)
    {
        for (final Object servlet : webApp.getServlets())
        {
            final org.eclipse.jst.j2ee.webapplication.Servlet j2eeServlet = (org.eclipse.jst.j2ee.webapplication.Servlet) servlet;
            final String servletClass = ((ServletTypeImpl) j2eeServlet.getWebType()).getClassName();
            if (servletClass.equals(servletClassName))
                return j2eeServlet;
        }
        return null;
    }


    /**
     * @param webapp
     * @param servletName
     * @return the servlet or null if not found
     */
    public static Servlet findServletByName (final WebApp webapp,
                                             final String servletName)
    {
        for (final Object s : webapp.getServlets())
        {
            final Servlet servlet = (Servlet) s;
            if (servlet.getServletName().trim().equals(servletName))
                return servlet;
        }

        return null;
    }


    /**
     * @param webApp
     * @param servlet
     */
    public static void removeServlet (final WebApp webApp,
                                      final Servlet servlet)
    {
        webApp.getServlets().remove(servlet);
    }


    /**
     * @param webapp
     * @param servletName
     * @param servletClass
     * @param urlPattern
     */
    public static void addServletMapping (final WebApp webapp,
                                          final String servletName,
                                          final String servletClass,
                                          final String urlPattern)
    {
        if (existsServletMapping(webapp, servletName, urlPattern))
            return;

        final Servlet servlet = findServlet(webapp, servletName, servletClass);
        if (servlet == null)
            throw new IllegalArgumentException("Cannot create servlet mapping with servlet name \"" //$NON-NLS-1$
                    + servletName + "\" and URL pattern \"" //$NON-NLS-1$
                    + urlPattern + "\". No corresponding servlet is defined."); //$NON-NLS-1$

        final ServletMapping servletMapping = WebapplicationFactory.eINSTANCE.createServletMapping();
        servletMapping.setServlet(servlet);
        servletMapping.setName(servletName);
        servletMapping.setUrlPattern(urlPattern);

        webapp.getServletMappings().add(servletMapping);
    }


    /**
     * @param webapp
     * @param servletName
     * @param urlPattern
     * @return true if the servlet mapping exists
     */
    public static boolean existsServletMapping (final WebApp webapp,
                                                final String servletName,
                                                final String urlPattern)
    {
        return findServletMapping(webapp, servletName, urlPattern) != null;
    }


    /**
     * @param webapp
     * @param servletName
     * @param urlPattern
     * @return the servlet mapping
     */
    public static ServletMapping findServletMapping (final WebApp webapp,
                                                     final String servletName,
                                                     final String urlPattern)
    {
        for (final Object mapping : webapp.getServletMappings())
        {
            final ServletMapping servletMapping = (ServletMapping) mapping;
            if (servletMapping.getName().equals(servletName)
                    && servletMapping.getUrlPattern().equals(urlPattern))
            {
                return servletMapping;
            }
        }

        return null;
    }


    /**
     * @param webApp
     * @param servlet
     */
    public static void removeServletMappings (final WebApp webApp,
                                              final Servlet servlet)
    {
        final List mappings = webApp.getServletMappings();
        String servletName = servlet.getServletName();

        if (servletName != null)
        {
            servletName = servletName.trim();
            for (int i = mappings.size() - 1; i >= 0; --i)
            {
                final ServletMapping mapping = (ServletMapping) mappings.get(i);
                if (mapping != null && mapping.getServlet().getServletName() != null
                        && mapping.getServlet().getServletName().trim().equals(servletName))
                {
                    mappings.remove(mapping);
                }
            }
        }
    }


    /**
     * @param webapp
     * @param filterName
     * @param filterClass
     */
    public static void addFilter (final WebApp webapp,
                                  final String filterName,
                                  final String filterClass)
    {
        if (existsFilter(webapp, filterName, filterClass))
            return;

        webapp.getFilters().add(createFilter(filterName, filterClass));
    }


    /**
     * @param filterName
     * @param filterClass
     * @return the filter or null if not found.
     */
    public static Filter createFilter (final String filterName,
                                       final String filterClass)
    {
        final Filter filter = WebapplicationFactory.eINSTANCE.createFilter();
        filter.setName(filterName);
        filter.setFilterClassName(filterClass);
        return filter;
    }


    /**
     * @param webapp
     * @param filterName
     * @param filterClass
     * @return true if the filter exists.
     */
    public static boolean existsFilter (final WebApp webapp,
                                        final String filterName,
                                        final String filterClass)
    {
        return findFilter(webapp, filterName, filterClass) != null;
    }


    /**
     * @param webapp
     * @param filterName
     * @param filterClass
     * @return the filter or null if not found.
     */
    public static Filter findFilter (final WebApp webapp,
                                     final String filterName,
                                     final String filterClass)
    {
        for (final Object f : webapp.getFilters())
        {
            final Filter filter = (Filter) f;
            if (filter.getName().trim().equals(filterName)
                    && filter.getFilterClassName().trim().equals(filterClass))
            {
                return filter;
            }
        }

        return null;
    }


    /**
     * @param webApp
     * @param filterClassName
     * @return the filter or null if not found.
     */
    public static Filter findFilter (final WebApp webApp,
                                     final String filterClassName)
    {
        for (final Object filter : webApp.getFilters())
        {
            if (((Filter) filter).getFilterClassName().trim().equals(filterClassName))
                return (Filter) filter;
        }

        return null;
    }


    /**
     * @param webapp
     * @param filterName
     * @param filterClass
     * @param servletName
     */
    public static void addFilterMapping (final WebApp webapp,
                                         final String filterName,
                                         final String filterClass,
                                         final String servletName)
    {
        if (existsFilterMapping(webapp, filterName, servletName))
            return;


        // Find corresponding filter
        final Filter filter = findFilter(webapp, filterName, filterClass);
        if (filter == null)
            throw new IllegalArgumentException("Cannot create filter mapping with filter name \"" //$NON-NLS-1$
                    + filterName + "\" and servlet name \"" //$NON-NLS-1$
                    + servletName + "\". No corresponding filter is defined."); //$NON-NLS-1$


        // Find corresponding servlet
        final Servlet servlet = findServletByName(webapp, servletName);
        if (servlet == null)
            throw new IllegalArgumentException("Cannot create filter mapping with filter name \"" //$NON-NLS-1$
                    + filterName + "\" and servlet name \"" //$NON-NLS-1$
                    + servletName + "\". No corresponding servlet is defined."); //$NON-NLS-1$


        // Create new filter mapping
        final FilterMapping filterMapping = WebapplicationFactory.eINSTANCE.createFilterMapping();
        filterMapping.setFilter(filter);
        filterMapping.setServlet(servlet);
        filterMapping.setServletName(servletName);

        webapp.getFilterMappings().add(filterMapping);
    }


    /**
     * @param webapp
     * @param filterName
     * @param servletName
     * @return true if the filter mapping exists
     */
    public static boolean existsFilterMapping (final WebApp webapp,
                                               final String filterName,
                                               final String servletName)
    {
        return findFilterMapping(webapp, filterName, servletName) != null;
    }


    /**
     * @param webapp
     * @param filterName
     * @param servletName
     * @return the filter mapping or null if it doesn't exist.
     */
    public static FilterMapping findFilterMapping (final WebApp webapp,
                                                   final String filterName,
                                                   final String servletName)
    {
        for (final Object fm : webapp.getFilterMappings())
        {
            final FilterMapping filterMapping = (FilterMapping) fm;

            if (filterMapping.getFilter().getName().trim().equals(filterName)
                    && filterMapping.getServletName().equals(servletName))
            {
                return filterMapping;
            }
        }

        return null;
    }


    /**
     * @param webApp
     * @param paramName
     * @param paramValue
     * @param description
     */
    public static void addContextParam (final WebApp webApp,
                                        final String paramName,
                                        final String paramValue,
                                        final String description)
    {
        if (existsContextParam(webApp, paramName, paramValue))
            return;

        webApp.getContextParams().add(createContextParam(paramName, paramValue, description));
    }


    /**
     * @param paramName
     * @param paramValue
     * @param descriptionString
     * @return the param value or null if doesn't exist
     */
    public static ParamValue createContextParam (final String paramName,
                                                 final String paramValue,
                                                 final String descriptionString)
    {
        final ParamValue param = CommonFactory.eINSTANCE.createParamValue();
        param.setName(paramName);
        param.setValue(paramValue);

        if (descriptionString != null)
        {
            final Description description = CommonFactory.eINSTANCE.createDescription();
            description.setValue(descriptionString);
            param.getDescriptions().add(description);
        }

        return param;
    }


    /**
     * @param webApp
     * @param paramName
     * @param paramValue
     * @return true if the context param exists.
     */
    public static boolean existsContextParam (final WebApp webApp,
                                              final String paramName,
                                              final String paramValue)
    {
        return findContextParam(webApp, paramName, paramValue) != null;
    }


    /**
     * @param webApp
     * @param paramName
     * @param paramValue
     * @return the param value or null if not found
     */
    public static ParamValue findContextParam (final WebApp webApp,
                                               final String paramName,
                                               final String paramValue)
    {
        for (final Object param : webApp.getContextParams())
        {
            final ParamValue contextParam = (ParamValue) param;
            if (contextParam.getName().equals(paramName)
                    && contextParam.getValue().equals(paramValue))
            {
                return contextParam;
            }
        }

        return null;
    }


    /**
     * @param webApp
     * @param paramName
     * @return the param value or null if not found
     */
    public static String getContextParamValue (final WebApp webApp,
                                               final String paramName)
    {
        for (final Object param : webApp.getContextParams())
        {
            final ParamValue contextParam = (ParamValue) param;
            if (contextParam.getName().equals(paramName))
            {
                return contextParam.getValue();
            }
        }

        return null;
    }


    /**
     * @param webApp
     * @param paramName Name of context param
     * @param valuesDelimiterRegex
     * @return Values of the given context param as a list
     */
    public static List<String> getContextParamValuesAsList (final WebApp webApp,
                                                            final String paramName,
                                                            final String valuesDelimiterRegex)
    {
        final String valuesString = getContextParamValue(webApp, paramName);
        return Arrays.asList(valuesString.split(valuesDelimiterRegex));
    }


    /**
     * Updates the value of a context param if it exists. Otherwise, adds this
     * as a new context param.
     * 
     * @param webApp
     * @param paramName
     * @param paramValue
     */
    public static void setContextParamValue (final WebApp webApp,
                                             final String paramName,
                                             final String paramValue)
    {
        ParamValue contextParam = null;

        for (final Object p : webApp.getContextParams())
        {
            final ParamValue param = (ParamValue) p;
            if (param.getName().equals(paramName))
            {
                contextParam = param;
                break;
            }
        }

        if (contextParam == null)
        {
            webApp.getContextParams().add(createContextParam(paramName, paramValue, null));
        }
        else
        {
            contextParam.setValue(paramValue);
        }
    }


    /**
     * @param webapp
     * @param listenerClass
     */
    public static void addListener (final WebApp webapp,
                                    final String listenerClass)
    {
        if (existsListener(webapp, listenerClass))
            return;

        // Create new listener
        final Listener listener = CommonFactory.eINSTANCE.createListener();
        listener.setListenerClassName(listenerClass);

        webapp.getListeners().add(listener);
    }


    /**
     * @param webapp
     * @param listenerClass
     * @return true if the listener exists
     */
    public static boolean existsListener (final WebApp webapp,
                                          final String listenerClass)
    {
        return findListener(webapp, listenerClass) != null;
    }


    /**
     * @param webapp
     * @param listenerClass
     * @return the listener or null if not found
     */
    public static Listener findListener (final WebApp webapp,
                                         final String listenerClass)
    {
        for (final Object listener : webapp.getListeners())
            if (((Listener) listener).getListenerClassName().equals(listenerClass))
                return (Listener) listener;

        return null;
    }
}
