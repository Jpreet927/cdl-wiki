import { PlayerStats } from "../types/PlayerStats";
import opticLight from "@/assets/logos/OpTic_Texas_Light.png";
import opticDark from "@/assets/logos/OpTic_Texas_Dark.png";
import dashy from "@/assets/headshots/Dashy_2023 (1).png";

export const PLAYER_STATS_DATA: PlayerStats[] = [
    {
        player: {
            id: 1,
            alias: "Dashy",
            name: "Brandon Ottell",
            team: {
                id: 1,
                name: "OpTic Texas",
                location: "Texas",
                created: new Date("2021-11-23"),
                affiliated: "Envy",
                coach: "Karma",
                owner: "Hector Rodrigez",
                points: 50,
                bgColoured: "",
                bgDark: "",
                bgLight: "",
                logoLight: opticLight,
                logoDark: opticDark,
            },
            dob: new Date("2021-11-23"),
            nationality: "Canadian",
            role: "Player",
            headshot: dashy,
        },
        matchId: 1,
        mode: "Hardpoint",
        map: "Invasion",
        kills: 24,
        deaths: 18,
        assists: 6,
        damage: 2800,
    },
    {
        player: {
            id: 1,
            alias: "Dashy",
            name: "Brandon Ottell",
            team: {
                id: 1,
                name: "OpTic Texas",
                location: "Texas",
                created: new Date("2021-11-23"),
                affiliated: "Envy",
                coach: "Karma",
                owner: "Hector Rodrigez",
                points: 50,
                bgColoured: "",
                bgDark: "",
                bgLight: "",
                logoLight: opticLight,
                logoDark: opticDark,
            },
            dob: new Date("2021-11-23"),
            nationality: "Canadian",
            role: "Player",
            headshot: dashy,
        },
        matchId: 1,
        mode: "Search and Destroy",
        map: "Karachi",
        kills: 8,
        deaths: 5,
        assists: 6,
        damage: 1200,
    },
    {
        player: {
            id: 1,
            alias: "Dashy",
            name: "Brandon Ottell",
            team: {
                id: 1,
                name: "OpTic Texas",
                location: "Texas",
                created: new Date("2021-11-23"),
                affiliated: "Envy",
                coach: "Karma",
                owner: "Hector Rodrigez",
                points: 50,
                bgColoured: "",
                bgDark: "",
                bgLight: "",
                logoLight: opticLight,
                logoDark: opticDark,
            },
            dob: new Date("2021-11-23"),
            nationality: "Canadian",
            role: "Player",
            headshot: dashy,
        },
        matchId: 1,
        mode: "Control",
        map: "Highrise",
        kills: 21,
        deaths: 20,
        assists: 7,
        damage: 2900,
    },
];
