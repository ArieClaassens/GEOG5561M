Copyright and Author Information:

Copyright (C) 2014 Student 200825599 gy13awc@leeds.ac.uk
University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
All rights reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program in the form of a file labelled gpl.txt.  
If not, see <http://www.gnu.org/licenses/>.

Application Overview:

This application provides a mechanism to remove high frequency noise from an image
 by accepting an array of values, representing a single band of image data, which 
is then put through a filtering process where the median of each cell is 
calculated and stored in a new array.

The median calculation process utilises diagonal neighbourhood calculation, with
the number of neighbours defined by the user-supplied radius parameter and the 
median calculation algorithm defined by the user-supplied algorithm choice.

Only cells that can be fully processed are included in the analysis.

For background information, please visit the following sites:

http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/median.html
http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/neighbourhoods.html
http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/conservative.html
http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/mean.html
