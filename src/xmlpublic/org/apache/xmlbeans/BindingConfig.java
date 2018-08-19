/*   Copyright 2004 The Apache Software Foundation
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*  limitations under the License.
*/

package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/**
 * The BindingConfig class is used during compilation to control the generation of java source files.
 * The default BindingConfig does nothing, but sub-classes should provide more interesting behavior.
 *
 * @see XmlBeans#compileXmlBeans(String, SchemaTypeSystem, XmlObject[], BindingConfig, SchemaTypeLoader, Filer, XmlOptions) XmlBeans.compileXmlBeans()
 */
public class BindingConfig
{
    private static final InterfaceExtension[] EMPTY_INTERFACE_EXT_ARRAY = new InterfaceExtension[0];
    private static final PrePostExtension[] EMPTY_PREPOST_EXT_ARRAY = new PrePostExtension[0];
    private static final UserType[] EMPTY_USER_TYPE_ARRY = new UserType[0];

    public static final int QNAME_TYPE = 1;
    public static final int QNAME_DOCUMENT_TYPE = 2;
    public static final int QNAME_ACCESSOR_ELEMENT = 3;
    public static final int QNAME_ACCESSOR_ATTRIBUTE = 4;

    /**
     * @param uri the namespace uri
     * @return the package name for a namespace or null.
     */
    public String lookupPackageForNamespace(String uri) { return null; }

    /**
     * @param uri the namespace uri
     * @return the prefix applied to each java name for a namespace or null.
     */
    public String lookupPrefixForNamespace(String uri) { return null; }

    /**
     * @param uri the namespace uri
     * @return Get the suffix applied to each java name for a namespace or null.
     */
    public String lookupSuffixForNamespace(String uri) { return null; }

    /**
     * @param qname the qname of the java name
     * @return the java name for a QName or null.
     * @deprecated replaced with {@link #lookupJavanameForQName(QName, int)}
     */
    public String lookupJavanameForQName(QName qname) { return null; }

    /**
     * @param qname the qname of the java name
     * @param kind the type of the qname, which one of {@link #QNAME_TYPE}, {@link #QNAME_DOCUMENT_TYPE},
     *             {@link #QNAME_ACCESSOR_ELEMENT}, {@link #QNAME_ACCESSOR_ATTRIBUTE}
     *
     * @return Get the java name for a QName of a specific component kind, or null.
     */
    public String lookupJavanameForQName(QName qname, int kind) { return null; }

    /**
     * @return all configured InterfaceExtensions or an empty array.
     */
    public InterfaceExtension[] getInterfaceExtensions() { return EMPTY_INTERFACE_EXT_ARRAY; }

    /**
     * @param fullJavaName the fully qualified java type name
     * @return all InterfaceExtensions defined for the fully qualified java
     * type generated from schema compilation or an empty array.
     */
    public InterfaceExtension[] getInterfaceExtensions(String fullJavaName) { return EMPTY_INTERFACE_EXT_ARRAY; }

    /**
     * @return all configued PrePostExtensions or an empty array.
     */
    public PrePostExtension[] getPrePostExtensions() { return EMPTY_PREPOST_EXT_ARRAY; }

    /**
     * @param fullJavaName the fully qualified java type name
     * @return the PrePostExtension defined for the fully qualified java
     * type generated from schema compilation or null.
     */
    public PrePostExtension getPrePostExtension(String fullJavaName) { return null; }

    /**
     * @return all defined user types.
     */
    public UserType[] getUserTypes() { return EMPTY_USER_TYPE_ARRY; }

    /**
     * @param qname the qname of the user type
     * @return a user defined Java type for a given QName.
     */
    public UserType lookupUserTypeForQName(QName qname) { return null; }

}
