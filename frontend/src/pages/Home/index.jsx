import React from 'react'

import NetflixLogo from '../../assets/netflix_logo.png'
import userBlue from '../../assets/blue_profile.png'
import userGreen from '../../assets/green_profile.png'
import userRed from '../../assets/red_profile.png'
import userYellow from '../../assets/yellow_profile.png'

import { HomeStyle } from './styles'

function Home(){
    return(
        <React.Fragment>   
            <HomeStyle>
            <main>
                <div>
                    <div>Quem está assistindo?</div>
                    <ul>
                        <li>
                            <img src={userBlue} alt="user_blue"/>
                            <span>Teste</span>
                        </li>
                        <li>
                            <img src={userGreen} alt="user_green"/>
                            <span>Teste</span>
                        </li>
                        <li>
                            <img src={userRed} alt="user_red"/>
                            <span>Teste</span>
                        </li>
                        <li>
                            <img src={userYellow} alt="user_yellow"/>
                            <span>Teste</span>
                        </li>
                    </ul>
                    <span>GERENCIAR PERFIS</span>
                </div>
            </main>
            </HomeStyle>
        </React.Fragment>
    )
}

export default Home