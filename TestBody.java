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
 * This is the unit test (using the JUnit Framework) of Body
 */

public class TestBody extends TestCase
{
	private Body sun = null;
	
	public void setUp()
	{
		sun = new Body("Sun", 1000);
	}
    public void testBody()
    {
        assertTrue(sun != null);
    }

    public void testGetName()
    {
        assertTrue(sun.getName().equals("Sun"));
    }

    public void testGetDescription()
    {
        assertTrue(sun.getDescription().equals("Sun"));
    }

    public void testGetMass()
    {
        assertTrue(sun.getMass() == 1000);
    }

    public void testGetTotalMass()
    {
        assertTrue(sun.getTotalMass() == 1000);
    }

    public static TestSuite suite()
    {
        return new TestSuite(TestBody.class);
    }
}