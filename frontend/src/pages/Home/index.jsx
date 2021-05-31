import React from 'react'

import NetflixLogo from '../../assets/netflix_logo.png'
import userBlue from '../../assets/blue_profile.png'
import userGreen from '../../assets/green_profile.png'
import userRed from '../../assets/red_profile.png'
import userYellow from '../../assets/yellow_profile.png'

import { Logo, Avatar, ManageProfile, MainContent} from './styles'

function Home(){
    return(
        <React.Fragment>               
            <MainContent>
                <Logo>
                    <img className="NetflixLogo" src={NetflixLogo} alt="netflix_logo"/>
                </Logo>

                <span>Quem está assistindo?</span>
                <Avatar>
                    <button onClick={teste}>
                        <div>
                            <img src={userYellow} alt="user_yellow"/>
                        </div>
                        <div>
                            <span>nome</span>
                        </div>
                    </button>

                    <button>
                        <div>
                            <img src={userBlue} alt="user_blue"/>
                        </div>
                        <div>
                            <span>nome</span>
                        </div>
                    </button>

                    <button>
                        <div>
                            <img src={userRed} alt="user_red"/>
                        </div>
                        <div>
                            <span>nome</span>
                        </div>
                    </button>

                    <button>
                        <div>
                            <img src={userGreen} alt="user_green"/>
                        </div>
                        <div>
                            <span>nome</span>
                        </div>
                    </button>

                </Avatar>

                <ManageProfile>
                    <button>GERENCIAR PERFIS</button>
                </ManageProfile>
            </MainContent>
        </React.Fragment>
    )

    function teste (){
        console.log("teste");
    }
}

export default Home