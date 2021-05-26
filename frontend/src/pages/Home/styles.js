import styled from 'styled-components'
import userYellow from '../../assets/yellow_profile.png'


export const MainContent = styled.main`
    height: 100vh;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;    

    span {
        height: 3.5vw;
        color: #fff;
        font-size: 3.5vw;
    }
`

export const Logo = styled.div`
    width: 100vw;
    height: 50px;
    display: flex;
    align-items: center;
    margin-left: 45px;
    img {
        max-width: 115px;
        margin-top: 10px;
    }
`

export const Avatar = styled.div`

    width: 100%;
    height: 200px;
    display: flex;
    justify-content: center;
    button {
        max-width: 139px;
        max-height: 139px;
        margin-right: 27px;
        border: none;
        border-radius: 5px;
        
        div{
            img {
            max-width: 139px;
            max-height: 139px;
            border-radius: 5px;
            }
        }

        div {
            margin: .6em 0;

            span {
                line-height: 1.2em;
                min-height: 1.8em;
                color: grey;
                text-align: center;
                font-size: 1.3vw;
            }
        }
        
    }

`

export const ManageProfile = styled.div`

    text-align: center;
    height: 100px;
    min-height: 50px;
    min-height: 50px;
 
    button {
        color: grey;
        border: 1px solid grey;
        padding: .5em 1.5em;
        font-size: 1.2vw;
        letter-spacing: 2px;
    }

`