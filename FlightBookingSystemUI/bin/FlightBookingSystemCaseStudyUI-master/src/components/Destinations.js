import React from 'react'
import image1 from '../assets/image1.jpg'
import image2 from '../assets/image2.jpg'
import image3 from '../assets/image3.jpg'

const Destinations = () => {
  return (
    <section className='destinations'>
      <h3>Now available in 10+ countries!</h3>
      <br></br><br></br>
      <div className='grid'>
        <div>
          <img src={image1} alt='destination-1' />
          <h3>Fly to UAE</h3>
          <p>
          The tourist industry of the United Arab Emirates is the most successful among the Gulf nations, and have long enjoyed status as the leading tourist nation of the GCC.The country is also the major tourist force in the Arab world
          </p>
        </div>

        <div>
          <img src={image2} alt='destination-2' />
          <h3>Europe Trips</h3>
          <p>
          It is the third most populated continent in the world. Bordered by the Atlantic Ocean on the west, Arctic Ocean on the north, Ural mountains in the east, and the Mediterranean Sea to the South, a visit to the European continent is visually magnificent and historically significant.
          </p>
        </div>

        <div>
          <img src={image3} alt='destination-3' />
          <h3>Maldives Special</h3>
          <p>
          Maldives is a popular destination amongst tourists, especially from India. Tourism in Maldives offers variety of sightseeing and entertainment options. ... Discover Maldives tourism places and stay in good hotels close to the main Maldives tourist spots.
          </p>
        </div>
      </div>
    </section>
  )
}

export default Destinations
