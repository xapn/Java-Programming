/**
 * This package is dedicated to using the Annotation Processing Tool
 * (APT) of the JDK 5 for taking in charge the @TODO annotation.
 * It contains classes needed by APT that implement the following interfaces:
 * <ul>
 * <li>AnnotationProcessorFactory: interface to be implemented to create a
 * factory usable by the APT.</li>
 * <li>AnnotationProcessor: a simple interface with only one method:
 * "public void process();"</li>
 * <li>DeclarationVisitor: visitors can visit all the type declarations of a
 * source code file.</li>
 * </ul>
 * There is also another important data file:
 * com.sun.mirror.apt.AnnotationProcessorFactory, in the META-INF/services
 * directory. This text file contains the complete name of the different
 * factories used by APT.
 */
package xapn.projects.javaprogramming.annotation.customized.todo.apt;