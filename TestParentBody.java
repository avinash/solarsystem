/***************************************************************************
 *   Copyright (C) 2005 by Avinash Meetoo - avinash@uom.ac.mu              *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 ***************************************************************************/

import junit.framework.*;

/**
 * This is the unit test (using the JUnit Framework) of NaturalBody
 */

public class TestParentBody extends TestCase
{
	private ParentBody sun = null;
	
	public void setUp()
	{
		sun = new ParentBody("Sun", 1000);
	}
	
    public void testParentBody()
    {
        assertTrue(sun != null);
    }

    public void testGetName()
    {
        assertTrue(sun.getName().equals("Sun"));
    }

    public void testAdd()
    {
        try {
            sun.add(new Body("Earth", 100));
        }

        catch (ExistingException e) {
            assertTrue(false);
            return;
        }

        assertTrue(true);
    }

    public void testGetDescription()
    {
        assertTrue(sun.getDescription().equals("Sun( )"));

        try {
            sun.add(new Body("Earth", 100));
        }

        catch (ExistingException e) {
            assertTrue(false);
            return;
        }

        assertTrue(sun.getDescription().equals("Sun( Earth )"));

        setUp();
        
        try {
            sun.add(new ParentBody("Earth", 100));
        }

        catch (ExistingException e) {
            assertTrue(false);
            return;
        }

        assertTrue(sun.getDescription().equals("Sun( Earth( ) )"));
    }

    public void testGetTotalMass()
    {
        assertTrue(sun.getTotalMass() == 1000);

        try {
            sun.add(new Body("Earth", 100));
        }

        catch (ExistingException e) {
            assertTrue(false);
            return;
        }

        assertTrue(sun.getTotalMass() == 1100);

        setUp();
        
        try {
            sun.add(new ParentBody("Earth", 100));
        }

        catch (ExistingException e) {
            assertTrue(false);
            return;
        }

        assertTrue(sun.getTotalMass() == 1100);
    }

    public void testRemoveNotExisting()
    {
        try {
            sun.remove("Earth");
        }

        catch (NonExistingException e) {
            assertTrue(true);
            return;
        }

        assertTrue(false);
    }

    public void testRemoveExisting()
    {
        try {
            sun.add(new Body("Earth", 100));

            sun.remove("Earth");
        }

        catch (ExistingException e) {
            assertTrue(false);
            return;
        }

        catch (NonExistingException e) {
            assertTrue(false);
            return;
        }

        assertTrue(true);
    }

    public void testRemoveExistingFromMany()
    {
        try {
            sun.add(new Body("Venus", 100));
            sun.add(new Body("Earth", 100));
            sun.add(new Body("Mars", 100));

            sun.remove("Earth");
        }

        catch (ExistingException e) {
            assertTrue(false);
            return;
        }

        catch (NonExistingException e) {
            assertTrue(false);
            return;
        }

        assertTrue(true);
    }

    public static TestSuite suite()
    {
        return new TestSuite(TestParentBody.class);
    }
}