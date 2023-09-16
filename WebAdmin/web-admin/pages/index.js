import Head from 'next/head';
import styles from '../styles/Home.module.css';
import { MyForm } from './model/model';

export default function App() {
  return (
    <div className={styles.container}>
      <Head>
        <title>AdminWeb</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <main>
        <MyForm />
      </main>

      <footer>
        
      </footer>
    
    </div>
  );
}
