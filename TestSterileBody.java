/***************************************************************************
 Copyright (C) 2005 by Avinash Meetoo - avinash@uom.ac.mu              *
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
 * This is the unit test (using the JUnit Framework) of ArtificialBody
 */

public class TestSterileBody extends TestCase
{
	private SterileBody hubble = null;
	
	public void setUp()
	{
		hubble = new SterileBody("Hubble", 10);
	}
	
    public void testSterileBody()
    {
        assertTrue(hubble != null);
    }

    public void testGetName()
    {
        assertTrue(hubble.getName().equals("Hubble"));
    }

    public void testGetDescription()
    {
        assertTrue(hubble.getDescription().equals("Hubble"));
    }

    public void testGetMass()
    {
        assertTrue(hubble.getMass() == 10);
    }

    public void testGetTotalMass()
    {
        assertTrue(hubble.getTotalMass() == 10);
    }

    public static TestSuite suite()
    {
        return new TestSuite(TestSterileBody.class);
    }
}