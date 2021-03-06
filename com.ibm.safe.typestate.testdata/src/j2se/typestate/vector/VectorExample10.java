/*******************************************************************************
 * Copyright (c) 2004-2010 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package j2se.typestate.vector;

import java.util.Random;
import java.util.Vector;

/**
 * Should produce a true error with any engine.
 * 
 * @author Stephen Fink
 */
public final class VectorExample10 {

  public static void main(String[] args) {
    try {
      Vector v1 = new Vector();
      Vector v2 = new Vector();

      init(v1, v2);

      Cell head = new Cell();
      Cell tail = head;
      for (int i = 0; i < 100; i++) {
        tail.next = new Cell();
        tail = tail.next;
      }

      boolean b = (new Random().nextBoolean());
      if (b) {
        head.next.v = v1;
      } else {
        head.next.v = v2;
      }
      head.next.v.firstElement();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @param v1
   * @param v2
   */
  private static void init(Vector v1, Vector v2) {
    v1.add(new Object());
    v2.removeAllElements();
  }

  private static class Cell {
    Cell next;

    Vector v;
  }
}